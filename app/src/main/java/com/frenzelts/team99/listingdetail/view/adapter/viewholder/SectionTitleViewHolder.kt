package com.frenzelts.team99.listingdetail.view.adapter.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import com.frenzelts.team99.R
import com.frenzelts.team99.common.adapter.BaseViewHolder
import com.frenzelts.team99.databinding.ListingDetailItemSectionTitleBinding
import com.frenzelts.team99.listingdetail.view.model.SectionTitleUiModel
import java.util.Objects

class SectionTitleViewHolder(view: View): BaseViewHolder<SectionTitleUiModel>(view) {

    private val binding = ListingDetailItemSectionTitleBinding.bind(view)

    override fun bind(element: SectionTitleUiModel) {
        bindTitle(element)
    }

    override fun bind(element: SectionTitleUiModel, payloads: List<Objects>) {
        if(payloads.isEmpty()) bind(element)
    }

    private fun bindTitle(model: SectionTitleUiModel) {
        binding.listingDetailSectionTitle.text = model.text
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.listing_detail_item_section_title
    }
}