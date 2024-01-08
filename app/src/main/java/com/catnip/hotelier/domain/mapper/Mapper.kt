package com.catnip.hotelier.domain.mapper

import com.catnip.hotelier.data.model.response.AddressResponse
import com.catnip.hotelier.data.model.response.AttributesResponse
import com.catnip.hotelier.data.model.response.PlaceResponse
import com.catnip.hotelier.presentation.model.Address
import com.catnip.hotelier.presentation.model.Attributes
import com.catnip.hotelier.presentation.model.Place

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

fun AddressResponse.toAddress() = Address(
    this.district.orEmpty(),
    this.streetName.orEmpty()
)

fun AttributesResponse.toAttributes() = Attributes(
    areaSize = this.areaSize ?: 0,
    bathrooms = this.bathrooms ?: 0,
    bedrooms = this.bedrooms ?: 0,
    price = this.price ?: 0,
)

fun PlaceResponse.toPlace() = Place(
    address = this.address?.toAddress(),
    attributes = this.attributes?.toAttributes(),
    category = this.category.orEmpty(),
    completedAt = this.completedAt.orEmpty(),
    id = this.id ?: -1,
    photo = this.photo.orEmpty(),
    projectName = this.projectName.orEmpty(),
    tenure = this.tenure ?: 0
)

fun Collection<PlaceResponse>.toPlaces() = this.map { it.toPlace() }