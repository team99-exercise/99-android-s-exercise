package com.team99.exerciserhony.domain.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PropertyDetail(
    @Json(name = "address") val address: Address? = null,
    @Json(name = "attributes") val attributes: Attributes? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "id") val id: Int? = null,
    @Json(name = "photo") val photo: String? = null,
    @Json(name = "project_name") val projectName: String? = null,
    @Json(name = "property_details") val propertyDetails: List<Detail?>? = null
) {
    @JsonClass(generateAdapter = true)
    data class Address(
        @Json(name = "map_coordinates") val mapCoordinates: MapCoordinates? = null,
        @Json(name = "subtitle") val subtitle: String? = null,
        @Json(name = "title") val title: String? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class MapCoordinates(
            @Json(name = "lat") val lat: Double? = null,
            @Json(name = "lng") val lng: Double? = null
        )
    }

    @JsonClass(generateAdapter = true)
    data class Attributes(
        @Json(name = "area_size") val areaSize: Int? = null,
        @Json(name = "bathrooms") val bathrooms: Int? = null,
        @Json(name = "bedrooms") val bedrooms: Int? = null,
        @Json(name = "price") val price: Int? = null
    )

    @JsonClass(generateAdapter = true)
    data class Detail(
        @Json(name = "label") val label: String? = null,
        @Json(name = "text") val text: String? = null
    )

    companion object {
        val EMPTY get() = PropertyDetail()
    }

}
