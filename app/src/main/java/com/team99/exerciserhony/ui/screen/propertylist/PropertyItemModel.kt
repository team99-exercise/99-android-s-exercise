package com.team99.exerciserhony.ui.screen.propertylist

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import com.team99.exerciserhony.R
import com.team99.exerciserhony.domain.entity.Property
import com.team99.exerciserhony.utils.toUsdPerMonth
import kotlin.random.Random
import kotlin.random.nextInt

data class PropertyItemModel(
    private val imageUrl: String,
    val id: Int,
    val name: String,
    val streetName: String,
    val district: String,
    val category: String,
    val completedAt: String,
    val tenure: String,
    val bedrooms: String,
    val bathrooms: String,
    val area: String,
    val price: String
) {

    private var isMocked = false

    val imagePainter
        @Composable
        get() = if (isMocked) painterResource(id = R.drawable.property_image)
        else rememberAsyncImagePainter(
            model = imageUrl,
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )

    companion object {
        internal val MOCK
            get() = PropertyItemModel(
                imageUrl = "",
                id = Random.nextInt(1..1000000),
                name = "Parkview Apartments",
                streetName = "12 Meyappa Chettiar Rd",
                district = "D13",
                category = "Condo",
                completedAt = "2020",
                tenure = "1 yrs",
                bedrooms = "3 Beds",
                bathrooms = "2 Baths",
                area = "2561 sqft",
                price = 2561.toUsdPerMonth()
            ).apply { isMocked = true }

        internal val MOCK_LIST
            get() = listOf(MOCK, MOCK, MOCK)

        fun parseEntity(entity: Property): PropertyItemModel = with(entity) {
            PropertyItemModel(
                imageUrl = photo.orEmpty(),
                id = id!!,
                name = projectName.orEmpty(),
                streetName = address?.streetName.orEmpty(),
                district = address?.district.orEmpty(),
                category = category.orEmpty(),
                completedAt = completedAt.orEmpty(),
                tenure = "${tenure!!} yrs",
                bedrooms = "${attributes?.bedrooms!!} Beds",
                bathrooms = "${attributes.bathrooms!!} Baths",
                area = "${attributes.areaSize!!} sqft",
                price = attributes.price!!.toUsdPerMonth()
            )
        }
    }
}
