package co.ninetynine.android.exercisev2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import co.ninetynine.android.exercisev2.data.database.ListingItemEntity

@Dao
interface ListingItemDao {
    @Query("SELECT * FROM listingitementity")
    fun getAll() : List<ListingItemEntity>

    @Insert
    suspend fun insertAll(listingItems : List<ListingItemEntity>)
}