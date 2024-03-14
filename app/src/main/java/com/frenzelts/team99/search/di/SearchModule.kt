package com.frenzelts.team99.search.di

import com.frenzelts.team99.common.data.Api
import com.frenzelts.team99.search.domain.SearchRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class SearchModule {

    @SearchScope
    @Named("baseURL")
    @Provides
    fun provideBaseUrl(): String {
        return "https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/"
    }

    @SearchScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @SearchScope
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        @Named("baseURL") baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @SearchScope
    @Provides
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @SearchScope
    @Provides
    fun provideSearchRepository(api: Api): SearchRepository {
        return SearchRepository(api)
    }
}