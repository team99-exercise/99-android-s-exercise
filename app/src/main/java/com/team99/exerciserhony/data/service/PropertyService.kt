package com.team99.exerciserhony.data.service

import com.team99.exerciserhony.domain.entity.Property
import com.team99.exerciserhony.domain.entity.PropertyDetail
import retrofit2.http.GET

interface PropertyService {

    @GET("listings.json")
    suspend fun getPropertyList(): List<Property>

    @GET("details/0.json")
    suspend fun getPropertyDetail(): PropertyDetail

}
