package com.frenzelts.team99.listingdetail.view.adapter.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import com.frenzelts.team99.R
import com.frenzelts.team99.common.adapter.BaseViewHolder
import com.frenzelts.team99.common.util.loadImage
import com.frenzelts.team99.databinding.ListingDetailItemBasicInfoBinding
import com.frenzelts.team99.listingdetail.listener.ListingDetailListener
import com.frenzelts.team99.listingdetail.view.model.BasicInfoUiModel
import java.util.Objects


class BasicInfoViewHolder(
    view: View,
    private val listener: ListingDetailListener,
): BaseViewHolder<BasicInfoUiModel>(view) {

    private val binding = ListingDetailItemBasicInfoBinding.bind(view)

    override fun bind(element: BasicInfoUiModel) {
        bindPrice(element)
        bindImage(element)
        bindName(element)
        bindAddress(element)
        bindAttributes(element)
    }

    override fun bind(element: BasicInfoUiModel, payloads: List<Objects>) {
        if(payloads.isEmpty()) bind(element)
    }

    private fun bindImage(model: BasicInfoUiModel) {
        binding.basicInfoImageView.loadImage(model.imageUrl)
    }

    private fun bindName(model: BasicInfoUiModel) {
        binding.basicInfoTitle.text = model.name
    }

    private fun bindPrice(model: BasicInfoUiModel) {
        binding.basicInfoPrice.text = itemView.context.resources.getString(R.string.format_price).format(model.price)
    }

    private fun bindAddress(model: BasicInfoUiModel) {
        binding.basicInfoAddressTitle.text = model.addressTitle
        binding.basicInfoAddressSubtitle.text = model.addressSubtitle
        binding.listingDetailCtaViewMap.setOnClickListener {
            listener.onViewMapClicked(model.addressLong, model.addressLat, model.name)
        }
    }

    private fun bindAttributes(model: BasicInfoUiModel) {
        binding.listingDetailBedroom.text = itemView.context.resources.getString(R.string.format_bedrooms).format(model.bedrooms)
        binding.listingDetailBathroom.text = itemView.context.resources.getString(R.string.format_bathrooms).format(model.bathrooms)
        binding.listingDetailArea.text = itemView.context.resources.getString(R.string.format_area).format(model.area)
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.listing_detail_item_basic_info
    }
}