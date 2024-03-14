package com.frenzelts.team99.search.di

import com.frenzelts.team99.common.di.AppComponent
import com.frenzelts.team99.search.view.SearchActivity
import dagger.Component

@SearchScope
@Component(
    modules = [
        SearchModule::class,
        SearchBindModule::class
    ],
    dependencies = [AppComponent::class]
)
interface SearchComponent {
    fun inject(activity: SearchActivity)
}