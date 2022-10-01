package co.ninetynine.android.exercisev2.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ListingItemEntity(
    @PrimaryKey
    val listingId: Int,
    @ColumnInfo(name = "project_name") val projectName: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "completed_at") val completedAt: String,
    @ColumnInfo(name = "photo_url") val photoUrl: String,
    @ColumnInfo(name = "tenure") val tenure: Int,
    @ColumnInfo(name = "district") val district: String,
    @ColumnInfo(name = "street_name") val streetName: String,
    @ColumnInfo(name = "area_size") val areaSize: Int,
    @ColumnInfo(name = "bathrooms") val bathrooms: Int,
    @ColumnInfo(name = "bedrooms") val bedrooms: Int,
    @ColumnInfo(name = "price") val price: Int,
)