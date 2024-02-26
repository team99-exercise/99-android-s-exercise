package com.team99.exerciserhony.ui.screen.propertydetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import com.team99.exerciserhony.R
import com.team99.exerciserhony.domain.entity.PropertyDetail
import com.team99.exerciserhony.utils.toUsd
import kotlin.random.Random
import kotlin.random.nextInt

data class PropertyDetailModel(
    private val imageUrl: String,
    val id: Int,
    val price: String,
    val propertyName: String,
    val addressTitle: String,
    val addressSubTitle: String,
    val coordinate: Pair<Double, Double>,
    val bedrooms: String,
    val bathrooms: String,
    val area: String,
    val detailSection: DetailSection,
    val description: String
) {

    private var isMocked = false

    val imagePainter
        @Composable
        get() = if (isMocked) painterResource(id = R.drawable.property_detail)
        else rememberAsyncImagePainter(
            model = imageUrl,
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )

    data class DetailSection(
        val priceSqft: String,
        val floorLevel: String,
        val facing: String,
        val buildYear: String,
        val tenure: String,
        val type: String,
        val lastUpdated: String,
        val overlookingView: String = "",
        val furnishing: String = ""
    ) {
        companion object {
            val MOCK
                get() = DetailSection(
                    priceSqft = "${5700.toUsd()} psf",
                    floorLevel = "High (40 total)",
                    furnishing = "Unfurnished",
                    facing = "North",
                    overlookingView = "Park View",
                    buildYear = "2000",
                    tenure = "99-year leasehold",
                    type = "Condo",
                    lastUpdated = "2 min ago"
                )

            fun parseEntity(entity: List<PropertyDetail.Detail>): DetailSection {
                val priceSqft = entity.firstOrNull {
                    it.label.equals(PropertyDetail.Detail.LABEL_PRICE)
                }?.text.orEmpty()
                val floorLevel = entity.firstOrNull {
                    it.label.equals(PropertyDetail.Detail.LABEL_FLOOR_LEVEL)
                }?.text.orEmpty()
                val furnishing = ""
                val facing = entity.firstOrNull {
                    it.label.equals(PropertyDetail.Detail.LABEL_FACING)
                }?.text.orEmpty()
                val overlookingView = ""
                val buildYear = entity.firstOrNull {
                    it.label.equals(PropertyDetail.Detail.LABEL_BUILD_YEAR)
                }?.text.orEmpty()
                val tenure = entity.firstOrNull {
                    it.label.equals(PropertyDetail.Detail.LABEL_TENURE)
                }?.text.orEmpty()
                val type = entity.firstOrNull {
                    it.label.equals(PropertyDetail.Detail.LABEL_PROPERTY_TYPE)
                }?.text.orEmpty()
                val lastUpdated = entity.firstOrNull {
                    it.label.equals(PropertyDetail.Detail.LABEL_LAST_UPDATED)
                }?.text.orEmpty()
                return DetailSection(
                    priceSqft = "$priceSqft psf",
                    floorLevel = floorLevel,
                    furnishing = furnishing,
                    facing = facing,
                    overlookingView = overlookingView,
                    buildYear = buildYear,
                    tenure = tenure,
                    type = type,
                    lastUpdated = lastUpdated
                )
            }
        }
    }

    companion object {
        val MOCK
            get() = PropertyDetailModel(
                imageUrl = "",
                id = Random.nextInt(1..1000000),
                price = 5700.toUsd(),
                propertyName = "Parkview Apartments",
                addressTitle = "1 Keppel Bay View · Condo for Rent",
                addressSubTitle = "Telok Blangah / Harbourfront (D4)",
                coordinate = 1.3884286902614 to 103.87432292478,
                bedrooms = "3 Beds",
                bathrooms = "2 Baths",
                area = "1420 sqft",
                detailSection = DetailSection.MOCK,
                description = "Sit back and enjoy panorama views of Mount Faber and Sentosa. The views are just as good from inside this modern apartment, where sunlight pours in through walls of windows. Reflections at Keppel Bay in Singapore is a luxury waterfront residential complex on approximately 84,000 m² of land with 750m of shoreline."
            ).apply { isMocked = true }

        fun parseEntity(entity: PropertyDetail) = PropertyDetailModel(
            imageUrl = entity.photo.orEmpty(),
            id = entity.id!!,
            price = entity.attributes?.price!!.toUsd(),
            propertyName = entity.projectName.orEmpty(),
            addressTitle = entity.address?.title.orEmpty(),
            addressSubTitle = entity.address?.subtitle.orEmpty(),
            coordinate = entity.address?.mapCoordinates?.lat!! to entity.address.mapCoordinates.lng!!,
            bedrooms = "${entity.attributes.bedrooms!!} Beds",
            bathrooms = "${entity.attributes.bathrooms!!} Baths",
            area = "${entity.attributes.areaSize!!}} sqft",
            detailSection = DetailSection.parseEntity(entity.propertyDetails.orEmpty()),
            description = entity.description.orEmpty()
        )
    }
}
