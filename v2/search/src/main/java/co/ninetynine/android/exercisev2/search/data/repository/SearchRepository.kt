package co.ninetynine.android.exercisev2.search.data.repository

import co.ninetynine.android.exercisev2.data.database.ListingDao
import co.ninetynine.android.exercisev2.data.database.ListingItemEntity
import co.ninetynine.android.exercisev2.search.data.service.SearchService
import co.ninetynine.android.exercisev2.search.model.Address
import co.ninetynine.android.exercisev2.search.model.Attributes
import co.ninetynine.android.exercisev2.search.model.ListingItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val service: SearchService,
    private val dao: ListingDao
) {

    suspend fun getSearchResults(): List<ListingItem> = withContext(Dispatchers.Default) {
        dao.getAll()
            .map { it.toListingItem() }
            .ifEmpty {
                val apiResult = service.getSearchResults()
                dao.insertAll(apiResult.map { it.toEntity() })
                apiResult
            }
    }

    private fun ListingItem.toEntity(): ListingItemEntity {
        return ListingItemEntity(
            listingId = id,
            projectName = projectName,
            category = category,
            completedAt = completedAt,
            photoUrl = photoUrl,
            tenure = tenure,
            streetName = address.streetName,
            district = address.district,
            areaSize = attributes.areaSize,
            bathrooms = attributes.bathrooms,
            bedrooms = attributes.bedrooms,
            price = attributes.price
        )
    }


    private fun ListingItemEntity.toListingItem(): ListingItem {
        return ListingItem(
            id = listingId,
            address = Address(
                streetName = streetName,
                district = district
            ),
            attributes = Attributes(
                areaSize = areaSize,
                bathrooms = bathrooms,
                bedrooms = bedrooms,
                price = price
            ),
            category = category,
            completedAt = completedAt,
            photoUrl = photoUrl,
            projectName = projectName,
            tenure = tenure
        )
    }

}
