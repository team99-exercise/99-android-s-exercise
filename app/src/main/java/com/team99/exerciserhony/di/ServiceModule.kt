package com.team99.exerciserhony.di

import com.team99.exerciserhony.data.service.PropertyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun providePropertyService(retrofit: Retrofit): PropertyService =
        retrofit.create(PropertyService::class.java)

}
