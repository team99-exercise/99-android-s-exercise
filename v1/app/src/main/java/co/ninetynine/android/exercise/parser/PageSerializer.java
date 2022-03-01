package co.ninetynine.android.exercise.parser;

import co.ninetynine.android.exercise.model.FormBaseObject;
import co.ninetynine.android.exercise.model.Page;
import co.ninetynine.android.exercise.model.Row;
import co.ninetynine.android.exercise.model.RowCheckbox;
import co.ninetynine.android.exercise.model.RowRadio;
import co.ninetynine.android.exercise.model.RowText;
import co.ninetynine.android.exercise.model.Section;
import co.ninetynine.android.exercise.model.ShowHideFormBaseObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import timber.log.Timber;

/**
 * Custom deserializer used for parsing MessageAttachment object. Used to store the data object
 * as a JSON formatting string. Storing JSON information in any other format is causing issues
 * with Realm.
 */
public class PageSerializer implements JsonDeserializer<Page>, JsonSerializer<Page> {

  HashMap<String, Class<? extends Row>> rowClassTypes = new HashMap<>();

  public PageSerializer() {
    rowClassTypes.put("text", RowText.class);
    rowClassTypes.put("radio", RowRadio.class);
    rowClassTypes.put("checkbox", RowCheckbox.class);
  }


  /*
   * DESERIALISATION: JSON --> MODEL CLASS
   */
  @Override public Page deserialize(JsonElement json, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    Page page = new Page();
    JsonObject obj = json.getAsJsonObject();
    deserializeFormBaseObject(page, obj);

    //List of sections
    for (JsonElement element : obj.getAsJsonArray("sections")) {
      page.sections.add(deserializeSection(context, element.getAsJsonObject(), page.rowMap));
    }

    //Populating transient objects
    for (Section section : page.sections) {
      //Populating row objects for condition checks
      populateConditionCheckRows(section, page);

      for (Row row : section.rows) {
        //Populating row objects for condition checks
        populateConditionCheckRows(row, page);
      }
    }

    return page;
  }

  private void populateConditionCheckRows(ShowHideFormBaseObject object, Page page) {
    if (!object.visibleConditions.isEmpty()) {
      for (HashMap<String, JsonElement> condition : object.visibleConditions) {
        for (String conditionRowKey : condition.keySet()) {
          Row conditionRow = page.rowMap.get(conditionRowKey);
          if (conditionRow != null) { //There can be cases where a row is not found. Can happen when a rule applies to a row that is not available in the current form template
            conditionRow.hasDependantFormElements = true;
            object.rowsForConditions.put(conditionRowKey, conditionRow);
          }
        }
      }
    }
  }

  private Section deserializeSection(JsonDeserializationContext context, JsonObject obj, HashMap<String, Row> rowMap) {
    Section section = new Section();
    deserializeShowHideFormBaseObject(context, section, obj);

    //Footer
    JsonElement footer = obj.get("footer");
    if (footer != null && footer.isJsonPrimitive()) section.footer = footer.getAsString();

    //List of rows
    for (JsonElement element : obj.getAsJsonArray("rows")) {
      Row row = deserializeRow(context, element.getAsJsonObject());
      if (row != null) {
        section.rows.add(row);

        //Adding the row to the temporary map
        rowMap.put(row.key, row);
      }
    }

    return section;
  }

  public Row deserializeRow(JsonDeserializationContext context, JsonObject obj) {
    String type = obj.get("type").getAsString();
    Class rowClassType = rowClassTypes.get(type);

    if (rowClassType != null) { //Supported row type
      Timber.d("Key: " + obj.get("key").getAsString() + ", Type: " + type + ", Casting to: "
          + rowClassType.getSimpleName());
      Row row = context.deserialize(obj, rowClassType);

      //Reinitialising null values
      if (row.visibleConditions == null) row.visibleConditions = new ArrayList<>();
      if (row.value == null) row.value = JsonNull.INSTANCE;

      return row;
    } else { //Unidentified row type
      Timber.e("Unsupported form row type: " + type);
      return null;
    }
  }

  private void deserializeShowHideFormBaseObject(JsonDeserializationContext context,
        ShowHideFormBaseObject formObject, JsonObject obj) {
    deserializeFormBaseObject(formObject, obj);

    //Visible conditions parsing
    if (obj.has("visible_conditions")) {
      formObject.visibleConditions = context.deserialize(
          obj.get("visible_conditions"),
          new TypeToken<ArrayList<HashMap<String, JsonElement>>>(){}.getType()
      );
    }

    if (formObject.visibleConditions == null) { //Reinitializing visible conditions array list if it's null
      formObject.visibleConditions = new ArrayList<>();
    }
  }

  private void deserializeFormBaseObject(FormBaseObject formObject, JsonObject obj) {
    JsonElement key = obj.get("key");
    JsonElement title = obj.get("title");
    JsonElement value = obj.get("value");

    if (key != null && key.isJsonPrimitive()) formObject.key = key.getAsString();
    if (title != null && title.isJsonPrimitive()) formObject.title = title.getAsString();
    formObject.value = (value != null) ? value : JsonNull.INSTANCE;
  }

  /*
   * SERIALISATION: MODEL CLASS --> JSON
   */

  @Override
  public JsonElement serialize(Page src, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject pageObj = serializeFormBaseObject(src);

    //List of sections
    JsonArray sections = new JsonArray();
    for (Section section : src.sections) {
      sections.add(serializeSection(section, context));
    }
    pageObj.add("sections", sections);

    return pageObj;
  }

  private JsonObject serializeSection(Section src, JsonSerializationContext context) {
    JsonObject sectionObj = serializeShowHideFormBaseObject(src, context);

    //Footer
    sectionObj.addProperty("footer", src.footer);

    //List of rows
    JsonArray rows = new JsonArray();
    for (Row row : src.rows) {
      rows.add(context.serialize(row));
    }
    sectionObj.add("rows", rows);

    return sectionObj;
  }

  private JsonObject serializeShowHideFormBaseObject(ShowHideFormBaseObject src, JsonSerializationContext context) {
    JsonObject object = serializeFormBaseObject(src);

    //Visible conditions
    object.add("visible_conditions", context.serialize(src.visibleConditions));

    return object;
  }

  private JsonObject serializeFormBaseObject(FormBaseObject src) {
    JsonObject object = new JsonObject();
    object.addProperty("key", src.key);
    object.addProperty("title", src.title);
    object.add("value", src.value);
    return object;
  }
}
