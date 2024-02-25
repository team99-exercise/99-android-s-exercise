package com.team99.exerciserhony.di

import com.team99.exerciserhony.data.repository.PropertyRepositoryImpl
import com.team99.exerciserhony.domain.repository.PropertyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun providePropertyRepository(impl: PropertyRepositoryImpl): PropertyRepository

}
