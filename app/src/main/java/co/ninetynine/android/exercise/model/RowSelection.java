package co.ninetynine.android.exercise.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by suresh on 27/11/15.
 */
public class RowSelection extends Row<List<FormOption>> {
  @SerializedName("multiple") public boolean isMultipleChoice;
  public ArrayList<FormOption> options = new ArrayList<>();

  @Override public String getValueForDisplay() {
    if (value.isJsonArray()) { //Has to be an array of options [{ "label": "something", "value": "some_val" }, ...]
      JsonArray array = value.getAsJsonArray();
      StringBuilder builder = new StringBuilder();

      //List of selected option labels separated by commas ("Fridge, Washing Machine, ...")
      Iterator<JsonElement> iter = array.iterator();
      while (iter.hasNext()) {
        JsonElement selectedValue = iter.next();
        for (FormOption option : options) {
          if (option.value.equals(selectedValue)) {
            builder.append(option.label);
            if (iter.hasNext()) builder.append(", ");
            break;
          }
        }
      }

      return builder.toString();
    } else {
      for (FormOption option : options) {
        if (option.value.equals(value)) {
          return option.label;
        }
      }
    }

    return null;
  }

  @Override public void saveChosenValue(List<FormOption> valueToSave) throws ValidationException {
    //Validating number of options supplied if only a single option is allowed
    if (!isMultipleChoice && valueToSave.size() > 1) {
      throw new ValidationException("Only allowed to choose one option for this row!");
    }

    if (!isMultipleChoice) { //Single choice
      value = valueToSave.get(0).value;
    } else if (valueToSave.size() > 0) { //Multiple choice
      JsonArray chosenOptions = new JsonArray();
      for (FormOption option : valueToSave) {
        chosenOptions.add(option.value);
      }
      value = chosenOptions;
    } else {
      value = JsonNull.INSTANCE;
    }
  }
}