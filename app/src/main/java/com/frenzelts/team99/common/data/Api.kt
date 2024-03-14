package com.frenzelts.team99.common.data

import com.frenzelts.team99.listingdetail.domain.ListingDetailResponse
import com.frenzelts.team99.search.domain.ListingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("listings.json")
    suspend fun fetchListing(): Response<List<ListingResponse>>
    @GET("details/{id}.json")
    suspend fun fetchListingDetail(@Path("id") id: Long): Response<ListingDetailResponse>
}