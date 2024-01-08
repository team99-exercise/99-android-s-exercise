package com.catnip.hotelier.data.repository

import com.catnip.hotelier.base.core.ResultWrapper
import com.catnip.hotelier.base.core.proceed
import com.catnip.hotelier.data.datasource.PlaceDataSource
import com.catnip.hotelier.data.model.response.PlaceResponse
import kotlinx.coroutines.flow.Flow

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface PlaceRepository {
    fun getPlaces(): Flow<ResultWrapper<List<PlaceResponse>>>
}

class PlaceRepositoryImpl(private val dataSource: PlaceDataSource) : PlaceRepository {
    override fun getPlaces(): Flow<ResultWrapper<List<PlaceResponse>>> {
        return proceed(providerBlock = { dataSource.getPlaces() })
    }
}