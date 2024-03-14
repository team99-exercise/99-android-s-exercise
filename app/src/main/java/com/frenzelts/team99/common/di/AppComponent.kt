package com.frenzelts.team99.common.di

import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

}