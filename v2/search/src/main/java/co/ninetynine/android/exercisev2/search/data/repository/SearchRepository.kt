package co.ninetynine.android.exercisev2.search.data.repository

import co.ninetynine.android.exercisev2.data.database.AppDatabase
import co.ninetynine.android.exercisev2.search.data.service.SearchService
import co.ninetynine.android.exercisev2.search.model.ListingItem
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val service: SearchService,
    private val database: AppDatabase
) {

    suspend fun getSearchResults(): List<ListingItem> {
        return service.getSearchResults()
    }

}
