package com.frenzelts.team99.search.view.listener

import com.frenzelts.team99.search.view.model.ListingUiModel

interface ListingItemListener {
    fun onItemClicked(model: ListingUiModel)
}