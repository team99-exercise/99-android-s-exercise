package com.frenzelts.team99.search.view.adapter.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import com.frenzelts.team99.R
import com.frenzelts.team99.common.adapter.BaseViewHolder
import com.frenzelts.team99.databinding.SearchItemListingViewBinding
import com.frenzelts.team99.search.view.listener.ListingItemListener
import com.frenzelts.team99.search.view.model.ListingUiModel
import java.util.Objects

class ListingViewHolder(
    view: View,
    private val listingItemListener: ListingItemListener,
): BaseViewHolder<ListingUiModel>(view) {

    private val binding = SearchItemListingViewBinding.bind(view)

    override fun bind(element: ListingUiModel) {
        bindListingView(element)
        binding.listingCardView.setOnClickListener {
            listingItemListener.onItemClicked(element)
        }
    }

    override fun bind(element: ListingUiModel, payloads: List<Objects>) {
        if(payloads.isEmpty()) bind(element)
    }

    private fun bindListingView(model: ListingUiModel) {
        binding.listingCardView.bind(model)
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.search_item_listing_view
    }
}