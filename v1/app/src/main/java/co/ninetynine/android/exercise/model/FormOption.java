package co.ninetynine.android.exercise.model;

import com.google.gson.JsonElement;

/**
 * Created by suresh on 27/11/15.
 */
public class FormOption {
  public String label;
  public JsonElement value;

  @Override public String toString() {
    return "{label: " + label + ", value: " + value + "}";
  }
}
