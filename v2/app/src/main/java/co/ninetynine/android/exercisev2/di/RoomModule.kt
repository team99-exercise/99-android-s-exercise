package co.ninetynine.android.exercisev2.di

import android.content.Context
import androidx.room.Room
import co.ninetynine.android.exercisev2.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "nn-exercise-database"
    ).build()


    @Singleton
    @Provides
    fun providesListingItemDao(appDatabase: AppDatabase) = appDatabase.listingItemDao()

}