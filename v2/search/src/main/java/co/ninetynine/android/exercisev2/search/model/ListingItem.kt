package co.ninetynine.android.exercisev2.search.model

data class ListingItem(
    val address: Address,
    val attributes: Attributes,
    val category: String,
    val completedAt: String,
    val id: Int,
    val photoUrl: String,
    val projectName: String,
    val tenure: Int
)

data class Address(
    val district: String,
    val streetName: String,
)

data class Attributes(
    val areaSize: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int,
)
