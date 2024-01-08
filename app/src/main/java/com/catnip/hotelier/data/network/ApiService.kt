package com.catnip.hotelier.data.network

import com.catnip.hotelier.BuildConfig
import com.catnip.hotelier.data.model.response.PlaceResponse
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiService {
    @GET("listings.json")
    suspend fun getPlaces(): List<PlaceResponse>

    companion object {
        @JvmStatic
        operator fun invoke(
            chucker: ChuckerInterceptor,
            gsonConverterFactory: GsonConverterFactory
        ): ApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(chucker)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}