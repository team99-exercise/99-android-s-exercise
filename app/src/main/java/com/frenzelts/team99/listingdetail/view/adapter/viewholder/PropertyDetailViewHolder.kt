package com.frenzelts.team99.listingdetail.view.adapter.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import com.frenzelts.team99.R
import com.frenzelts.team99.common.adapter.BaseViewHolder
import com.frenzelts.team99.databinding.ListingDetailItemPropertyDetailBinding
import com.frenzelts.team99.listingdetail.view.model.PropertyDetailUiModel
import java.util.Objects

class PropertyDetailViewHolder(view: View): BaseViewHolder<PropertyDetailUiModel>(view) {

    private val binding = ListingDetailItemPropertyDetailBinding.bind(view)

    override fun bind(element: PropertyDetailUiModel) {
        bindDetails(element)
    }

    override fun bind(element: PropertyDetailUiModel, payloads: List<Objects>) {
        if(payloads.isEmpty()) bind(element)
    }

    private fun bindDetails(model: PropertyDetailUiModel) {
        binding.propertyDetailLabel.text = model.label
        binding.propertyDetailName.text = model.text
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.listing_detail_item_property_detail
    }
}