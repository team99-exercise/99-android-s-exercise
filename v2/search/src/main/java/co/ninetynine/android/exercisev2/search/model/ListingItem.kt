package co.ninetynine.android.exercisev2.search.model

import com.google.gson.annotations.SerializedName

data class ListingItem(
    @SerializedName("address")
    val address: Address,
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("category")
    val category: String,
    @SerializedName("completed_at")
    val completedAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("photo")
    val photoUrl: String,
    @SerializedName("project_name")
    val projectName: String,
    @SerializedName("tenure")
    val tenure: Int
)

data class Address(
    @SerializedName("district")
    val district: String,
    @SerializedName("street_name")
    val streetName: String,
)

data class Attributes(
    @SerializedName("area_size")
    val areaSize: Int,
    @SerializedName("bathrooms")
    val bathrooms: Int,
    @SerializedName("bedrooms")
    val bedrooms: Int,
    @SerializedName("price")
    val price: Int,
)
