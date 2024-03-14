package com.frenzelts.team99.search.view.listener

import android.content.Context
import android.content.Intent
import com.frenzelts.team99.listingdetail.view.ListingDetailActivity
import com.frenzelts.team99.search.view.model.ListingUiModel

class ListingItemCallback(
    private val context: Context
): ListingItemListener {
    override fun onItemClicked(model: ListingUiModel) {
        val intent = Intent(context, ListingDetailActivity::class.java)
        intent.putExtra(ListingDetailActivity.EXTRA_LISTING_ID, model.id)
        context.startActivity(intent)
    }
}