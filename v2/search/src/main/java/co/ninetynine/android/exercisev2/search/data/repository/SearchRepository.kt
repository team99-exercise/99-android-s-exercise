package co.ninetynine.android.exercisev2.search.data.repository

import co.ninetynine.android.exercisev2.data.dao.ListingItemDao
import co.ninetynine.android.exercisev2.data.database.AppDatabase
import co.ninetynine.android.exercisev2.search.data.mappers.ListItemMapper
import co.ninetynine.android.exercisev2.search.data.service.SearchService
import co.ninetynine.android.exercisev2.search.model.ListingItem
import javax.inject.Inject

class SearchRepository @Inject constructor(
    var service: SearchService,
    var listingItemDao: ListingItemDao,
    var listItemMapper: ListItemMapper
) {

    suspend fun getSearchResults(): List<ListingItem> {
        // 1. "Return results from `database` if not empty
        val resultFromDatabase = listingItemDao.getAll()
        return if (resultFromDatabase.isNotEmpty()) listItemMapper.mapAllToModel(resultFromDatabase)
        // 2. Else fetch results from `service`
        else {
            val resultFromService = service.getSearchResults()
            // 3. Cache results in `database`
            saveResultsToDatabase(resultFromService)
            // 4. Return results
            resultFromService
        }
    }

    private suspend fun saveResultsToDatabase(result : List<ListingItem>){
        listingItemDao.insertAll(listItemMapper.mapAllToRoom(result))
    }

}
