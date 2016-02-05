package co.ninetynine.android.exercise.model;

/**
 * Created by suresh on 14/12/15.
 */
public abstract class Row<T> extends ShowHideFormBaseObject {
  public String type;
  public String placeholder;

  public abstract String getValueForDisplay();
  public abstract void saveChosenValue(T valueToSave) throws ValidationException;

  //Thrown if there's a validation error. Will be populated with an error message. Can be retrieved by calling exception.getMessage()
  public static class ValidationException extends Exception {
    public ValidationException(String detailMessage) {
      super(detailMessage);
    }
  }
}
