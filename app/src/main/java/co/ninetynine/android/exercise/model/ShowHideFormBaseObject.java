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
  public transient boolean hasDependantFormElements = false;
  //Rows/sections that are dependant on the value of this row for visibility

  public boolean isVisible() {
    if (visibleConditions.isEmpty()) return true;

    //Timber.d("****");
    //Timber.d(((this instanceof Row) ? "Row" : "Section") + ": " + key + ", Title: " + title);
    //Timber.d("Conditions: " + visibleConditions);
    //OR condition. Any one has to be true
    for (HashMap<String, JsonElement> condition : visibleConditions) {
      if (evaluateCondition(condition)) return true;
    }
    //Timber.d("****");

    return false;
  }

  private boolean evaluateCondition(HashMap<String, JsonElement> condition) {
    //Timber.d("\t====");
    //Timber.d("\tCondition: " + condition);
    for (Map.Entry<String, JsonElement> entry : condition.entrySet()) {
      String rowKey = entry.getKey();
      JsonElement value = entry.getValue();

      Row row = rowsForConditions.get(rowKey);
      if (row == null || !row.value.equals(value)) {
        //Timber.d("\t" + entry + ": " + false);
        //Timber.d("\t====");
        return false; //AND condition. None of them should be false
      } else {
        //Timber.d("\t" + entry + ": " + true);
      }
    }

    //Timber.d("\tCondition is true");
    //Timber.d("\t====");
    return true;
  }
}
