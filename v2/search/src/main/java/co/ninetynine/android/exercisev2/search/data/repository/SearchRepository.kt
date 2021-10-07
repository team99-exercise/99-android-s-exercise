package co.ninetynine.android.exercisev2.search.data.repository

import co.ninetynine.android.exercisev2.data.database.AppDatabase
import co.ninetynine.android.exercisev2.search.data.service.SearchService
import co.ninetynine.android.exercisev2.search.model.ListingItem
import javax.inject.Inject

class SearchRepository @Inject constructor(
    var service: SearchService,
    var database: AppDatabase
) {

    fun getSearchResults(): List<ListingItem> {
        TODO()
        // 1. "Return results from `database` if not empty
        // 2. Else fetch results from `service`
        // 3. Cache results in `database`
        // 4. Return results
    }

}
