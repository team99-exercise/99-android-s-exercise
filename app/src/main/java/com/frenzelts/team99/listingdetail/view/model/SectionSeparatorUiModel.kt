package com.frenzelts.team99.listingdetail.view.model

import com.frenzelts.team99.common.visitable.BaseVisitable
import com.frenzelts.team99.listingdetail.view.adapter.ListingDetailTypeFactory

data class SectionSeparatorUiModel(
    override val id: Long
): ListingDetailVisitable {

    override fun type(typeFactory: ListingDetailTypeFactory): Int {
        return typeFactory.type(this)
    }

    override fun areContentsTheSame(newItem: BaseVisitable): Boolean {
        return this == newItem
    }

    companion object {
        const val ID_SEPARATOR_PROPERTY_DETAIL = 201L
        const val ID_SEPARATOR_DESC = 202L
    }
}
