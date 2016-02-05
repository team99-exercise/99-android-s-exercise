package co.ninetynine.android.exercise.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by suresh on 27/11/15.
 */
public class Section extends ShowHideFormBaseObject {
  public String footer;
  public ArrayList<Row> rows = new ArrayList<>();

  public boolean hasTitle() {
    return title != null;
  }

  public boolean hasFooter() {
    return footer != null;
  }
}
