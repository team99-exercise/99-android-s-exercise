package co.ninetynine.android.exercise.model

data class Section(
    val title: String?,
    val footer: String?,
    val visible_conditions: List<HashMap<String, String>?>?,
    val rows: List<Row>?
)