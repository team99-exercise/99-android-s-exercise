package com.frenzelts.team99.search.domain

import com.frenzelts.team99.search.view.model.ListingUiModel

object SearchMapper {
    fun ListingResponse.mapToUiModel(): ListingUiModel {
        return ListingUiModel(
            id = id,
            projectName = projectName,
            photo = photo,
            address = ListingUiModel.Address(
                district = address.district,
                streetName = address.streetName
            ),
            attributes = ListingUiModel.Attributes(
                areaSize = attributes.areaSize ?: 0,
                bathrooms = attributes.bathrooms ?: 0,
                bedrooms = attributes.bedrooms ?: 0,
                price = attributes.price ?: 0,
            ),
            category = category,
            completedAt = completedAt,
            tenure = tenure
        )
    }
}