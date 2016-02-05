package co.ninetynine.android.exercise.model;

import com.google.gson.JsonElement;

/**
 * Created by suresh on 27/11/15.
 */
public abstract class FormBaseObject {
  public String key, title, subtitle;
  public JsonElement value;
}