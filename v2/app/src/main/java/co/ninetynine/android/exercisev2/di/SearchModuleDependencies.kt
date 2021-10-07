package co.ninetynine.android.exercisev2.di

import co.ninetynine.android.exercisev2.data.database.AppDatabase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@EntryPoint
@InstallIn(SingletonComponent::class)
interface SearchModuleDependencies {

    fun getRetrofit(): Retrofit

    fun getAppDatabase(): AppDatabase

}
