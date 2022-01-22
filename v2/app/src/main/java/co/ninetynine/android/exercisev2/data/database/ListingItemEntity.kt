package co.ninetynine.android.exercisev2.data.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class ListingItemEntity(
    @PrimaryKey
    var listingId: Int,
    val category: String,
    val completedAt: String,
    val photoUrl: String,
    val projectName: String,
    val tenure: Int,
    @Embedded(prefix = "address")
    val address: AddressEntity,
    @Embedded(prefix = "attributes")
    val attributes: AttributesEntity,
)

class AddressEntity(
    val district: String,
    val streetName: String,
)

class AttributesEntity(
    val areaSize: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int,
)