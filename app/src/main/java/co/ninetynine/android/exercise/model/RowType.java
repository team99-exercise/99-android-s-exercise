package co.ninetynine.android.exercise.model;

public enum RowType {
    TEXT("text"),
    RADIO("radio"),
    CHECKBOX("checkbox");

    public final String value;
    RowType(String value) {
        this.value = value;
    }
}
