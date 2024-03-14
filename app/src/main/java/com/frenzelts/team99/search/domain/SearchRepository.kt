package com.frenzelts.team99.search.domain

import com.frenzelts.team99.common.data.Api
import java.lang.Exception

class SearchRepository (
    private val api: Api
) {
    suspend fun fetchRemote(): List<ListingResponse> {
        val response = api.fetchListing()
        return if(response.isSuccessful) {
            response.body().orEmpty()
        } else throw Exception(response.errorBody().toString())
    }
}