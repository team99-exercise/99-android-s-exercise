package co.ninetynine.android.exercise.model;

import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;

/**
 * Created by suresh on 27/11/15.
 */
public class RowText extends Row<String> {
  @SerializedName("multiple_line") public boolean isMultipleLine;

  @Override public String getValueForDisplay() {
    if (value.isJsonPrimitive()) {
      return value.getAsJsonPrimitive().getAsString();
    }

    return null;
  }

  @Override public void saveChosenValue(String valueToSave) throws ValidationException {
    value = new JsonPrimitive(valueToSave);
  }
}