package com.catnip.hotelier.data.model.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class AttributesResponse(
    @SerializedName("area_size")
    val areaSize: Int?,
    @SerializedName("bathrooms")
    val bathrooms: Int?,
    @SerializedName("bedrooms")
    val bedrooms: Int?,
    @SerializedName("price")
    val price: Int?
)