package com.frenzelts.team99.listingdetail.domain

import com.google.gson.annotations.SerializedName

data class ListingDetailResponse (
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
    @SerializedName("description")
    val description: String = "",
    @SerializedName("property_details")
    val propertyDetails: List<PropertyDetail> = listOf(),
) {
    data class Address(
        @SerializedName("title")
        val title: String = "",
        @SerializedName("subtitle")
        val subtitle: String = "",
        @SerializedName("map_coordinates")
        val coordinates: Coordinates = Coordinates(),
    ) {
        data class Coordinates(
            @SerializedName("lng")
            val longitute: Float = 0f,
            @SerializedName("lat")
            val lattitude: Float = 0f,

        )
    }

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

    data class  PropertyDetail(
        @SerializedName("label")
        val label: String,
        @SerializedName("text")
        val text: String,
    )
}