package com.team99.exerciserhony.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Named(TagInjection.OKHTTP_LOG_INTERCEPTOR)
    fun provideOkHttpLogInterceptor(): Interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideHttpClient(
        @Named(TagInjection.OKHTTP_LOG_INTERCEPTOR) okhttpLogInterceptor: Interceptor
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(okhttpLogInterceptor)
        //todo, add another interceptor here like chucker, header, stetho, etc.
        return client.build()
    }

    /**
     * We may need to add a custom factory
     */
    @Provides
    @Singleton
    fun provideMoshi():Moshi = Moshi.Builder().build()

    @Provides
    fun provideRetrofit(
        @Named(TagInjection.BASE_URL) baseUrl: String,
        httpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(httpClient)
        .build()

}
