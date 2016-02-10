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

  public void logPage() {
    for (Section section : sections) {
      section.logSection();
    }
  }
}