package com.team99.exerciserhony.domain.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Property(
    @Json(name = "address") val address: Address? = null,
    @Json(name = "attributes") val attributes: Attributes? = null,
    @Json(name = "category") val category: String? = null,
    @Json(name = "completed_at") val completedAt: String? = null,
    @Json(name = "id") val id: Int? = null,
    @Json(name = "photo") val photo: String? = null,
    @Json(name = "project_name") val projectName: String? = null,
    @Json(name = "tenure") val tenure: Int? = null
) {
    @JsonClass(generateAdapter = true)
    data class Address(
        @Json(name = "district") val district: String? = null,
        @Json(name = "street_name") val streetName: String? = null
    )

    @JsonClass(generateAdapter = true)
    data class Attributes(
        @Json(name = "area_size") val areaSize: Int? = null,
        @Json(name = "bathrooms") val bathrooms: Int? = null,
        @Json(name = "bedrooms") val bedrooms: Int? = null,
        @Json(name = "price") val price: Int? = null
    )
}
