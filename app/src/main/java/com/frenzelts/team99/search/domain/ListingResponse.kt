package com.frenzelts.team99.search.domain

import com.google.gson.annotations.SerializedName

data class ListingResponse (
    @SerializedName("id")
    val id: Long = 0L,
    @SerializedName("project_name")
    val projectName: String = "",
    @SerializedName("photo")
    val photo: String = "",
    @SerializedName("address")
    val address: Address = Address(),
    @SerializedName("attributes")
    val attributes: Attributes = Attributes(),
    @SerializedName("category")
    val category: String = "",
    @SerializedName("completed_at")
    val completedAt: String = "",
    @SerializedName("tenure")
    val tenure: Int = 0,
) {
    data class Address(
        @SerializedName("district")
        val district: String = "",
        @SerializedName("street_name")
        val streetName: String = "",
    )

    data class Attributes(
        @SerializedName("area_size")
        val areaSize: Int? = null,
        @SerializedName("bathrooms")
        val bathrooms: Int? = null,
        @SerializedName("bedrooms")
        val bedrooms: Int? = null,
        @SerializedName("price")
        val price: Int? = null,
    )
}