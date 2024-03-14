package com.frenzelts.team99.listingdetail.view.model

import com.frenzelts.team99.common.visitable.BaseVisitable
import com.frenzelts.team99.listingdetail.view.adapter.ListingDetailTypeFactory

data class BasicInfoUiModel(
    val name: String,
    val imageUrl: String,
    val addressTitle: String,
    val addressSubtitle: String,
    val addressLong: Float,
    val addressLat: Float,
    val price: Int,
    val bedrooms: Int,
    val bathrooms: Int,
    val area: Int,
): ListingDetailVisitable {
    override val id: Long
        get() = hashCode().toLong()

    override fun type(typeFactory: ListingDetailTypeFactory): Int {
        return typeFactory.type(this)
    }

    override fun areContentsTheSame(newItem: BaseVisitable): Boolean {
        return this == newItem
    }
}
