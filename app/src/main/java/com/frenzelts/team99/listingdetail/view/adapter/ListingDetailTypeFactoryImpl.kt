package com.frenzelts.team99.listingdetail.view.adapter

import android.view.View
import com.frenzelts.team99.common.visitable.BaseTypeFactoryImpl
import com.frenzelts.team99.common.adapter.BaseViewHolder
import com.frenzelts.team99.common.visitable.BaseVisitable
import com.frenzelts.team99.listingdetail.listener.ListingDetailListener
import com.frenzelts.team99.listingdetail.view.model.BasicInfoUiModel
import com.frenzelts.team99.listingdetail.view.model.DescriptionUiModel
import com.frenzelts.team99.listingdetail.view.model.PropertyDetailUiModel
import com.frenzelts.team99.listingdetail.view.model.SectionTitleUiModel
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.BasicInfoViewHolder
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.DescriptionViewHolder
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.PropertyDetailViewHolder
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.SectionSeparatorViewHolder
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.SectionTitleViewHolder
import com.frenzelts.team99.listingdetail.view.model.SectionSeparatorUiModel

class ListingDetailTypeFactoryImpl(
    private val listener: ListingDetailListener,
): ListingDetailTypeFactory, BaseTypeFactoryImpl() {
    override fun type(model: BasicInfoUiModel): Int {
        return BasicInfoViewHolder.LAYOUT
    }

    override fun type(model: SectionTitleUiModel): Int {
        return SectionTitleViewHolder.LAYOUT
    }

    override fun type(model: SectionSeparatorUiModel): Int {
        return SectionSeparatorViewHolder.LAYOUT
    }

    override fun type(model: PropertyDetailUiModel): Int {
        return PropertyDetailViewHolder.LAYOUT
    }

    override fun type(model: DescriptionUiModel): Int {
        return DescriptionViewHolder.LAYOUT
    }

    @Suppress("UNCHECKED_CAST")
    override fun createViewHolder(view: View, type: Int): BaseViewHolder<BaseVisitable> {
        return when(type) {
            BasicInfoViewHolder.LAYOUT -> BasicInfoViewHolder(view, listener)
            SectionTitleViewHolder.LAYOUT -> SectionTitleViewHolder(view)
            SectionSeparatorViewHolder.LAYOUT -> SectionSeparatorViewHolder(view)
            PropertyDetailViewHolder.LAYOUT -> PropertyDetailViewHolder(view)
            DescriptionViewHolder.LAYOUT -> DescriptionViewHolder(view)
            else -> super.createViewHolder(view, type)
        } as BaseViewHolder<BaseVisitable>
    }
}