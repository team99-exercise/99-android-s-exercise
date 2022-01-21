package co.ninetynine.android.exercisev2.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import co.ninetynine.android.exercisev2.data.dao.ListingItemDao

@Database(entities = [ListingItemEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun listingItemDao(): ListingItemDao
}