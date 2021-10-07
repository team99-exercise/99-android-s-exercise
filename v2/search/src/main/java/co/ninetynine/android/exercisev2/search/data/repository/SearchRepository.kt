package co.ninetynine.android.exercisev2.search.data.repository

import co.ninetynine.android.exercisev2.search.data.service.SearchService
import javax.inject.Inject

class SearchRepository @Inject constructor(
    var service: SearchService
) {

    suspend fun getSearchResults() = service.getSearchResults()

}
