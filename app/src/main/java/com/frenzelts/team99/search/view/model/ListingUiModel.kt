package com.frenzelts.team99.search.view.model

import com.frenzelts.team99.common.visitable.BaseVisitable
import com.frenzelts.team99.search.view.adapter.SearchTypeFactory

data class ListingUiModel (
    override val id: Long,
    val projectName: String,
    val photo: String,
    val address: Address,
    val attributes: Attributes,
    val category: String,
    val completedAt: String,
    val tenure: Int,
): SearchVisitable {

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

    override fun type(typeFactory: SearchTypeFactory): Int {
        return typeFactory.type(this)
    }

    override fun areContentsTheSame(newItem: BaseVisitable): Boolean {
        return this == newItem
    }
}