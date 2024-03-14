package com.frenzelts.team99.search.view.adapter

import android.view.View
import com.frenzelts.team99.common.visitable.BaseTypeFactoryImpl
import com.frenzelts.team99.common.adapter.BaseViewHolder
import com.frenzelts.team99.common.visitable.BaseVisitable
import com.frenzelts.team99.search.view.adapter.viewholder.ListingViewHolder
import com.frenzelts.team99.search.view.listener.ListingItemListener
import com.frenzelts.team99.search.view.model.ListingUiModel

class SearchTypeFactoryImpl(
    private val listingItemListener: ListingItemListener,
): SearchTypeFactory, BaseTypeFactoryImpl() {
    override fun type(model: ListingUiModel): Int {
        return ListingViewHolder.LAYOUT
    }

    @Suppress("UNCHECKED_CAST")
    override fun createViewHolder(view: View, type: Int): BaseViewHolder<BaseVisitable> {
        return when(type) {
            ListingViewHolder.LAYOUT -> ListingViewHolder(view, listingItemListener)
            else -> super.createViewHolder(view, type)
        } as BaseViewHolder<BaseVisitable>
    }
}