package com.frenzelts.team99.search.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.frenzelts.team99.common.di.ViewModelFactory
import com.frenzelts.team99.common.di.ViewModelKey
import com.frenzelts.team99.listingdetail.viewmodel.ListingDetailViewModel
import com.frenzelts.team99.search.viewmodel.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SearchBindModule {

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun getSearchViewModel(viewModel: SearchViewModel): ViewModel
}