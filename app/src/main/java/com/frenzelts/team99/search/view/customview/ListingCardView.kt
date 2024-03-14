package com.frenzelts.team99.search.view.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.frenzelts.team99.R
import com.frenzelts.team99.common.util.loadImage
import com.frenzelts.team99.databinding.ListingCardViewBinding
import com.frenzelts.team99.search.view.model.ListingUiModel

class ListingCardView: CardView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: ListingCardViewBinding = ListingCardViewBinding.inflate(LayoutInflater.from(context), this)

    fun bind(model: ListingUiModel) {
        bindImage(model.photo)
        bindTitle(model.projectName)
        bindAddress(model.address)
        bindInfo(category = model.category, completedAt = model.completedAt, tenure = model.tenure)
        bindAttributes(model.attributes)
    }

    private fun bindImage(imageUrl: String) {
        binding.listingImageView.loadImage(imageUrl)
    }

    private fun bindTitle(title: String) {
        binding.listingTitle.text = title
    }

    private fun bindAddress(address: ListingUiModel.Address) {
        binding.listingStreetName.text = address.streetName
        binding.listingDistrict.text = address.district
    }

    private fun bindInfo(
        category: String,
        completedAt: String,
        tenure: Int,
    ) {
        binding.listingCategory.text = category
        binding.listingCompletedAt.text = completedAt
        binding.listingTenure.text = context.resources.getString(R.string.format_tenure).format(tenure)
    }

    private fun bindAttributes(attributes: ListingUiModel.Attributes) {
        binding.listingBedrooms.text = context.resources.getString(R.string.format_bedrooms).format(attributes.bedrooms)
        binding.listingBathrooms.text = context.resources.getString(R.string.format_bathrooms).format(attributes.bathrooms)
        binding.listingArea.text = context.resources.getString(R.string.format_area).format(attributes.areaSize)
        binding.listingPrice.text = context.resources.getString(R.string.format_price_per_month).format(attributes.price)
    }
}