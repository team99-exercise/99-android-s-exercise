package co.ninetynine.android.exercise.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;

/**
 * Created by suresh on 27/11/15.
 */
public class RowRadio extends Row<FormOption> {
  public ArrayList<FormOption> options = new ArrayList<>();

  @Override public FormOption getValueForDisplay() {
    for (FormOption option : options) {
      if (option.value.equals(value)) {
        return option;
      }
    }

    return null;
  }

  @Override public void saveChosenValue(FormOption valueToSave) throws ValidationException {
    value = valueToSave.value;
  }
}