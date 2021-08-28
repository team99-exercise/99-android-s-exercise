package co.ninetynine.android.exercise.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import timber.log.Timber;

/**
 * Created by suresh on 27/11/15.
 */
public class Section extends FormBaseObject {
  public String footer;
  public ArrayList<Row> rows = new ArrayList<>();

  public boolean hasTitle() {
    return title != null && !title.isEmpty();
  }

  public boolean hasFooter() {
    return footer != null && !footer.isEmpty();
  }

  public void logSection() {
    Timber.d("++ Section: " + super.toString() + "[footer=" + footer + "]\n");
    for (Row row : rows) {
      Timber.d("\t-- " + row);
    }
  }
}
