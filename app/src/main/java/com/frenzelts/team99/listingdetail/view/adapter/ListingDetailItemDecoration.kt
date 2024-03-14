package com.frenzelts.team99.listingdetail.view.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.frenzelts.team99.R
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.BasicInfoViewHolder
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.DescriptionViewHolder
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.PropertyDetailViewHolder
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.SectionSeparatorViewHolder
import com.frenzelts.team99.listingdetail.view.adapter.viewholder.SectionTitleViewHolder

object ListingDetailItemDecoration: ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val resources = view.resources
        val viewPosition = parent.getChildAdapterPosition(view)
        parent.adapter?.let {
            if(viewPosition < 0 || viewPosition >= it.itemCount) return
            val viewType = it.getItemViewType(viewPosition)
            outRect.right = resources.getDimensionPixelOffset(R.dimen.listing_detail_horizontal_margin)
            outRect.left = resources.getDimensionPixelOffset(R.dimen.listing_detail_horizontal_margin)
            when(viewType) {
                BasicInfoViewHolder.LAYOUT -> {
                    outRect.left = 0
                    outRect.right = 0
                    outRect.top = 0
                    outRect.bottom = resources.getDimensionPixelOffset(R.dimen.listing_detail_default_inner_padding)
                }
                SectionTitleViewHolder.LAYOUT -> {
                    outRect.top = resources.getDimensionPixelOffset(R.dimen.listing_detail_default_inner_padding)
                    outRect.bottom = resources.getDimensionPixelOffset(R.dimen.listing_detail_default_inner_padding)
                }
                SectionSeparatorViewHolder.LAYOUT -> {
                    outRect.top = resources.getDimensionPixelOffset(R.dimen.listing_detail_separator_top_padding)
                    outRect.bottom = resources.getDimensionPixelOffset(R.dimen.listing_detail_default_inner_padding)
                }
                PropertyDetailViewHolder.LAYOUT -> {
                    outRect.top = resources.getDimensionPixelOffset(R.dimen.listing_detail_property_detail_padding)
                    outRect.bottom = resources.getDimensionPixelOffset(R.dimen.listing_detail_property_detail_padding)
                }
                DescriptionViewHolder.LAYOUT -> {
                    outRect.top = resources.getDimensionPixelOffset(R.dimen.listing_detail_default_inner_padding)
                    outRect.bottom = resources.getDimensionPixelOffset(R.dimen.listing_detail_default_inner_padding)
                }
            }
            if(viewPosition == it.itemCount - 1) {
                outRect.bottom = resources.getDimensionPixelOffset(R.dimen.listing_detail_bottom_padding)
            }
        }
    }
}