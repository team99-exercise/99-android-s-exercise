package com.frenzelts.team99.search.view.adapter

import com.frenzelts.team99.common.visitable.BaseTypeFactory
import com.frenzelts.team99.search.view.model.ListingUiModel

interface SearchTypeFactory: BaseTypeFactory {
    fun type(model: ListingUiModel): Int = -1
    // to be added with other search result components
}