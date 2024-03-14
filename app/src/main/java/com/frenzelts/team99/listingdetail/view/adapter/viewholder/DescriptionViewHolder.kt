package com.frenzelts.team99.listingdetail.view.adapter.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import com.frenzelts.team99.R
import com.frenzelts.team99.common.adapter.BaseViewHolder
import com.frenzelts.team99.databinding.ListingDetailItemDescriptionBinding
import com.frenzelts.team99.listingdetail.view.model.DescriptionUiModel
import java.util.Objects

class DescriptionViewHolder(view: View): BaseViewHolder<DescriptionUiModel>(view) {

    private val binding = ListingDetailItemDescriptionBinding.bind(view)

    override fun bind(element: DescriptionUiModel) {
        bindDescription(element)
    }

    override fun bind(element: DescriptionUiModel, payloads: List<Objects>) {
        if(payloads.isEmpty()) bind(element)
    }

    private fun bindDescription(model: DescriptionUiModel) {
        binding.listingDetailDescription.text = model.text
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.listing_detail_item_description
    }
}