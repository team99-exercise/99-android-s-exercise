package com.frenzelts.team99.listingdetail.di

import com.frenzelts.team99.common.di.AppComponent
import com.frenzelts.team99.listingdetail.view.ListingDetailActivity
import dagger.Component

@ListingDetailScope
@Component(
    modules = [
        ListingDetailModule::class,
        ListingDetailBindModule::class
    ],
    dependencies = [AppComponent::class]
)
interface ListingDetailComponent {
    fun inject(activity: ListingDetailActivity)
}