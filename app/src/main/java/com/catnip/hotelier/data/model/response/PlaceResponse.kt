package com.catnip.hotelier.data.model.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class PlaceResponse(
    @SerializedName("address")
    val address: AddressResponse?,
    @SerializedName("attributes")
    val attributes: AttributesResponse?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("completed_at")
    val completedAt: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("project_name")
    val projectName: String?,
    @SerializedName("tenure")
    val tenure: Int?
)