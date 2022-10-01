package co.ninetynine.android.exercisev2.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ListingDao {
    @Insert
    fun insertAll(listings: List<ListingItemEntity>)

    @Query("SELECT * FROM ListingItemEntity")
    fun getAll(): List<ListingItemEntity>
}