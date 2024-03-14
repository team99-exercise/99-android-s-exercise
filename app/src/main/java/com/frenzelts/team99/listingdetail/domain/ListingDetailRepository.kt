package com.frenzelts.team99.listingdetail.domain

import com.frenzelts.team99.common.data.Api
import java.lang.Exception

class ListingDetailRepository (
    private val api: Api
) {
    suspend fun fetchRemote(id: Long): ListingDetailResponse {
        val response = api.fetchListingDetail(id)
        return if(response.isSuccessful) {
            response.body() ?: throw Exception(response.errorBody().toString())
        } else throw Exception(response.errorBody().toString())
    }
}