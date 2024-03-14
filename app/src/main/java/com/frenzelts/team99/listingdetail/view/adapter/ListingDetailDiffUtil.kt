package com.frenzelts.team99.listingdetail.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.frenzelts.team99.listingdetail.view.model.ListingDetailVisitable

class ListingDetailDiffUtil: DiffUtil.ItemCallback<ListingDetailVisitable>() {
    override fun areItemsTheSame(
        oldItem: ListingDetailVisitable,
        newItem: ListingDetailVisitable
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ListingDetailVisitable,
        newItem: ListingDetailVisitable
    ): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}