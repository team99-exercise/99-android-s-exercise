package co.ninetynine.android.exercise.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import timber.log.Timber;

/**
 * Created by suresh on 27/11/15.
 */
public class Page extends FormBaseObject {
  public ArrayList<Section> sections = new ArrayList<>();
  public transient HashMap<String, Row> rowMap = new HashMap<>(); //Convenient way to query for rows based on their keys

  /**
   * Generate a JSON object payload that contains all the form values that the user has entered
   * @return JSON object containing rows that have any user input
   */
  public JsonObject createPayload() {
    JsonObject object = new JsonObject();

    for (Section section : sections) {
      if (!section.isVisible()) continue; //Ignore hidden sections

      for (Row row : section.rows) {
        if (!row.value.isJsonNull()) { //Add this row to the payload if the value is NOT NULL
          object.add(row.key, row.value);
        }
      }
    }

    return object;
  }

  /**
   * Helper method to load values into the form template. Can be used to restore saved forms etc.
   * @param savedValues JSON object returned by the createPayload() method
   */
  public void loadSavedValues(JsonObject savedValues) {
    if (savedValues == null) return;

    //Replacing row values with existing unsaved data if available
    for (Map.Entry<String, JsonElement> entry : savedValues.entrySet()) {
      Row row = rowMap.get(entry.getKey());
      JsonElement savedValue = entry.getValue();

      if (row != null) {
        if (row instanceof RowRadio) { //Radio button row. Check and load value
          checkAndLoadRadioOption((RowRadio) row, savedValue);
        } else { //Any other row. Just save the value
          row.value = savedValue;
        }
      }
    }
  }

  private void checkAndLoadRadioOption(RowRadio row, JsonElement savedValue) {
    for (FormOption option : row.options) {
      if (option.value.equals(savedValue)) {
        row.value = savedValue;
      }
    }
  }

  public void logPage() {
    for (Section section : sections) {
      section.logSection();
    }
  }
}