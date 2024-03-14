package com.frenzelts.team99.listingdetail.view.adapter

import com.frenzelts.team99.common.visitable.BaseTypeFactory
import com.frenzelts.team99.listingdetail.view.model.BasicInfoUiModel
import com.frenzelts.team99.listingdetail.view.model.DescriptionUiModel
import com.frenzelts.team99.listingdetail.view.model.PropertyDetailUiModel
import com.frenzelts.team99.listingdetail.view.model.SectionSeparatorUiModel
import com.frenzelts.team99.listingdetail.view.model.SectionTitleUiModel

interface ListingDetailTypeFactory: BaseTypeFactory {
    fun type(model: BasicInfoUiModel): Int
    fun type(model: SectionTitleUiModel): Int
    fun type(model: SectionSeparatorUiModel): Int
    fun type(model: PropertyDetailUiModel): Int
    fun type(model: DescriptionUiModel): Int
    // to be added with other search result components
}