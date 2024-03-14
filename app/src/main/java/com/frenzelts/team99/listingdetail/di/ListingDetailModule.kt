package com.frenzelts.team99.listingdetail.di

import com.frenzelts.team99.common.data.Api
import com.frenzelts.team99.listingdetail.domain.ListingDetailRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class ListingDetailModule {

    @ListingDetailScope
    @Named("baseURL")
    @Provides
    fun provideBaseUrl(): String {
        return "https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/"
    }

    @ListingDetailScope
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

    @ListingDetailScope
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

    @ListingDetailScope
    @Provides
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @ListingDetailScope
    @Provides
    fun provideListingDetailRepository(api: Api): ListingDetailRepository {
        return ListingDetailRepository(api)
    }
}