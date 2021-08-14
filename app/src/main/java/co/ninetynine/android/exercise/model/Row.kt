package co.ninetynine.android.exercise.model

data class Row(
    val title: String?,
    val type: String?,
    val value: Any?,
    val visible_conditions: Any?,
    val key: String?,
    val options: List<Option>?,
    val placeholder: String?
)