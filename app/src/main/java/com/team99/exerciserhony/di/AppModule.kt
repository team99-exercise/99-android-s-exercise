package com.team99.exerciserhony.di

import com.team99.exerciserhony.BuildConfig
import com.team99.exerciserhony.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Named(TagInjection.BASE_URL)
    fun provideBaseUrl(): String = BuildConfig.BASE_URL

    @Provides
    fun provideDispatcherProvider(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
    }

}
