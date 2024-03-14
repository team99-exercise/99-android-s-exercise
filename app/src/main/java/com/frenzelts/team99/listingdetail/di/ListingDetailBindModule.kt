package com.frenzelts.team99.listingdetail.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.frenzelts.team99.common.di.ViewModelFactory
import com.frenzelts.team99.common.di.ViewModelKey
import com.frenzelts.team99.listingdetail.viewmodel.ListingDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListingDetailBindModule {

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListingDetailViewModel::class)
    abstract fun getSearchViewModel(viewModel: ListingDetailViewModel): ViewModel
}