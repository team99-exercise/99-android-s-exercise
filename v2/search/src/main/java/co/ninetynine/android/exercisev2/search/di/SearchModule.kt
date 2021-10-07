package co.ninetynine.android.exercisev2.search.di

import co.ninetynine.android.exercisev2.search.data.repository.SearchRepository
import co.ninetynine.android.exercisev2.search.data.service.SearchService
import co.ninetynine.android.exercisev2.search.viewmodel.SearchViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SearchModule {

    @Provides
    @Singleton
    fun provideSearchService(retrofit: Retrofit) =
        retrofit.create(SearchService::class.java)

    @Provides
    @Singleton
    fun provideSearchRepository(service: SearchService) =
        SearchRepository(service)

    @Provides
    @Singleton
    fun provideSearchViewModelFactory(repository: SearchRepository) =
        SearchViewModelFactory(repository)

}
