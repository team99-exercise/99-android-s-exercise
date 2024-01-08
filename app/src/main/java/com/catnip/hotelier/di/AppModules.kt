package com.catnip.hotelier.di

import com.catnip.hotelier.data.datasource.PlaceApiDataSource
import com.catnip.hotelier.data.datasource.PlaceDataSource
import com.catnip.hotelier.data.network.ApiService
import com.catnip.hotelier.data.repository.PlaceRepository
import com.catnip.hotelier.data.repository.PlaceRepositoryImpl
import com.catnip.hotelier.domain.usecase.GetPlaceUseCase
import com.catnip.hotelier.presentation.feature.searchresult.SearchResultViewModel
import com.chuckerteam.chucker.api.ChuckerInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
object AppModules {

    private val networkModule = module {
        single { ChuckerInterceptor(androidContext()) }
        single { GsonConverterFactory.create() }
        single { ApiService.invoke(get(), get()) }
    }

    private val dataSourceModule = module {
        single<PlaceDataSource> { PlaceApiDataSource(get()) }
    }

    private val repositoryModule = module {
        single<PlaceRepository> { PlaceRepositoryImpl(get()) }
    }

    private val useCaseModule = module {
        single { GetPlaceUseCase(get()) }
    }

    private val viewModelModule = module {
        viewModelOf(::SearchResultViewModel)
    }

    val modules: List<Module> = listOf(
        networkModule,
        dataSourceModule,
        repositoryModule,
        useCaseModule,
        viewModelModule,
    )
}
