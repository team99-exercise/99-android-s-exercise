package co.ninetynine.android.exercisev2.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ListingItemEntity(
    @PrimaryKey
    var listingId: Int
)