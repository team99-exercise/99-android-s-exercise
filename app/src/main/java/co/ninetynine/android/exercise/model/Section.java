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

  public int getSectionItemCount() {
    int count = 2; //Header + footer

    //Counting the number of visible rows
    for (Row row : rows) {
      if (row.isVisible()) count++;
    }

    return count;
  }

  public Row getRow(int position) {
    return rows.get(position);
  }

  public boolean hasTitle() {
    return true;
  }

  public boolean hasFooter() {
    return true;
  }
}
