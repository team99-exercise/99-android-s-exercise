package com.frenzelts.team99.listingdetail.view.model

import com.frenzelts.team99.common.visitable.BaseVisitable
import com.frenzelts.team99.listingdetail.view.adapter.ListingDetailTypeFactory

data class DescriptionUiModel(
    val text: String,
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
