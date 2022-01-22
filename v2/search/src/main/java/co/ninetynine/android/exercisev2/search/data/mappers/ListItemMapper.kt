package co.ninetynine.android.exercisev2.search.data.mappers

import co.ninetynine.android.exercisev2.data.database.AddressEntity
import co.ninetynine.android.exercisev2.data.database.AttributesEntity
import co.ninetynine.android.exercisev2.data.database.ListingItemEntity
import co.ninetynine.android.exercisev2.search.model.Address
import co.ninetynine.android.exercisev2.search.model.Attributes
import co.ninetynine.android.exercisev2.search.model.ListingItem
import javax.inject.Inject

class ListItemMapper @Inject constructor(): Mapper<ListingItem, ListingItemEntity> {

    override fun mapToRoom(input: ListingItem): ListingItemEntity {
        return ListingItemEntity(
            input.id,
            input.category,
            input.completedAt,
            input.photoUrl,
            input.projectName,
            input.tenure,
            AddressEntity(
                input.address.district,
                input.address.streetName
            ),
            AttributesEntity(
                input.attributes.areaSize,
                input.attributes.bathrooms,
                input.attributes.bedrooms,
                input.attributes.price
            )
        )
    }

    override fun mapToModel(input: ListingItemEntity): ListingItem {
        return ListingItem(
            Address(
                input.address.district,
                input.address.streetName
            ),
            Attributes(
                input.attributes.areaSize,
                input.attributes.bathrooms,
                input.attributes.bedrooms,
                input.attributes.price
            ),
            input.category,
            input.completedAt,
            input.listingId,
            input.photoUrl,
            input.projectName,
            input.tenure
        )
    }

    override fun mapAllToRoom(input: List<ListingItem>): List<ListingItemEntity> = input.map { mapToRoom(it) }

    override fun mapAllToModel(input: List<ListingItemEntity>): List<ListingItem> = input.map { mapToModel(it) }


}