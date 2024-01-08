package com.catnip.hotelier.data.datasource

import com.catnip.hotelier.data.model.response.PlaceResponse
import com.catnip.hotelier.data.network.ApiService

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface PlaceDataSource {
    suspend fun getPlaces() : List<PlaceResponse>
}

class PlaceApiDataSource(private val service: ApiService) : PlaceDataSource{
    override suspend fun getPlaces(): List<PlaceResponse> {
        return service.getPlaces()
    }
}