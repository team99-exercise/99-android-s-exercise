package co.ninetynine.android.exercisev2.search.data.repository

import co.ninetynine.android.exercisev2.search.data.service.SearchService

class SearchRepository(
    private val service: SearchService
) {

    suspend fun getSearchResults() = service.getSearchResults()

}
