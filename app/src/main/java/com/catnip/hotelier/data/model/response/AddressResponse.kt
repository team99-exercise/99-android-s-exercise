package com.catnip.hotelier.data.model.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class AddressResponse(
    @SerializedName("district")
    val district: String?,
    @SerializedName("street_name")
    val streetName: String?
)