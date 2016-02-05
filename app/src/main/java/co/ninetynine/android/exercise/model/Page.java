package co.ninetynine.android.exercise.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by suresh on 27/11/15.
 */
public class Page extends FormBaseObject {
  public ArrayList<Section> sections = new ArrayList<>();
  public transient HashMap<String, Row> rowMap = new HashMap<>(); //Convenient way to query for rows based on their keys
}