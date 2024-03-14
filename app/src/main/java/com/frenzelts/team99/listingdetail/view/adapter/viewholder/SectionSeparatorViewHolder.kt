package com.frenzelts.team99.listingdetail.view.adapter.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import com.frenzelts.team99.R
import com.frenzelts.team99.common.adapter.BaseViewHolder
import com.frenzelts.team99.databinding.ListingDetailSeparatorBinding
import com.frenzelts.team99.listingdetail.view.model.SectionTitleUiModel
import java.util.Objects

class SectionSeparatorViewHolder(view: View): BaseViewHolder<SectionTitleUiModel>(view) {

    private val binding = ListingDetailSeparatorBinding.bind(view)

    override fun bind(element: SectionTitleUiModel) { }

    override fun bind(element: SectionTitleUiModel, payloads: List<Objects>) {}

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.listing_detail_separator
    }
}