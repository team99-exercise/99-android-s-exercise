package co.ninetynine.android.exercisev2.search.viewmodel

data class State<T>(
    val error: Throwable? = null,
    val data: T? = null,
    val isLoading: Boolean = false
)