package co.ninetynine.android.exercise.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import timber.log.Timber;

/**
 * Created by suresh on 27/11/15.
 */
public abstract class ShowHideFormBaseObject extends FormBaseObject {
  @SerializedName("visible_conditions") public ArrayList<HashMap<String, JsonElement>> visibleConditions = new ArrayList<>();
  public transient HashMap<String, Row> rowsForConditions = new HashMap<>(); //Convenient way to access rows for evaluating conditions

  public boolean isVisible() {
    if (visibleConditions.isEmpty()) return true;

    for (HashMap<String, JsonElement> condition : visibleConditions) {
      if (evaluateCondition(condition)) return true;
    }

    return false;
  }

  private boolean evaluateCondition(HashMap<String, JsonElement> condition) {
    for (Map.Entry<String, JsonElement> entry : condition.entrySet()) {
      String rowKey = entry.getKey();
      JsonElement value = entry.getValue();

      Row row = rowsForConditions.get(rowKey);
      if (row == null || !row.value.equals(value)) {
        return false; //AND condition. None of them should be false
      }
    }

    return true;
  }

  @Override public String toString() {
    return super.toString() + " [visible_conditions=" + visibleConditions + "]";
  }
}
