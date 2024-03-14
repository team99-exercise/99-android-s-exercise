package com.frenzelts.team99.listingdetail.domain

import com.frenzelts.team99.listingdetail.view.model.BasicInfoUiModel
import com.frenzelts.team99.listingdetail.view.model.DescriptionUiModel
import com.frenzelts.team99.listingdetail.view.model.ListingDetailVisitable
import com.frenzelts.team99.listingdetail.view.model.PropertyDetailUiModel
import com.frenzelts.team99.listingdetail.view.model.SectionSeparatorUiModel
import com.frenzelts.team99.listingdetail.view.model.SectionSeparatorUiModel.Companion.ID_SEPARATOR_DESC
import com.frenzelts.team99.listingdetail.view.model.SectionSeparatorUiModel.Companion.ID_SEPARATOR_PROPERTY_DETAIL
import com.frenzelts.team99.listingdetail.view.model.SectionTitleUiModel
import com.frenzelts.team99.listingdetail.view.model.SectionTitleUiModel.Companion.TITLE_DESCRIPTION
import com.frenzelts.team99.listingdetail.view.model.SectionTitleUiModel.Companion.TITLE_PROPERTY_DETAILS

object ListingDetailMapper {
    fun ListingDetailResponse.mapToUiModel(): List<ListingDetailVisitable> {
        return mutableListOf<ListingDetailVisitable>().apply {
            addBasicInfo(this@mapToUiModel)
            add(SectionSeparatorUiModel(ID_SEPARATOR_PROPERTY_DETAIL))
            addSectionTitle(TITLE_PROPERTY_DETAILS)
            addPropertyDetails(this@mapToUiModel)
            add(SectionSeparatorUiModel(ID_SEPARATOR_DESC))
            addSectionTitle(TITLE_DESCRIPTION)
            addDescription(this@mapToUiModel)
        }
    }

    private fun MutableList<ListingDetailVisitable>.addBasicInfo(model: ListingDetailResponse) {
        val basicUiModel = BasicInfoUiModel(
            name = model.projectName,
            imageUrl = model.photo,
            addressTitle = model.address.title,
            addressSubtitle = model.address.subtitle,
            addressLong = model.address.coordinates.longitute,
            addressLat = model.address.coordinates.lattitude,
            price = model.attributes.price ?: 0,
            bedrooms = model.attributes.bedrooms ?: 0,
            bathrooms = model.attributes.bathrooms ?: 0,
            area = model.attributes.areaSize ?: 0,
        )
        add(basicUiModel)
    }

    private fun MutableList<ListingDetailVisitable>.addSectionTitle(title: String) {
        add(SectionTitleUiModel(title))
    }

    private fun MutableList<ListingDetailVisitable>.addPropertyDetails(model: ListingDetailResponse) {
        val details = model.propertyDetails.map {
            PropertyDetailUiModel(
                label = it.label,
                text = it.text
            )
        }
        addAll(details)
    }

    private fun MutableList<ListingDetailVisitable>.addDescription(model: ListingDetailResponse) {
        add(DescriptionUiModel(model.description))
    }
}