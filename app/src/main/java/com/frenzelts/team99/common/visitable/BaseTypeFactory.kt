package com.frenzelts.team99.common.visitable

import android.view.View
import com.frenzelts.team99.common.adapter.BaseViewHolder

interface BaseTypeFactory {
    fun type(model: LoadingUiModel): Int = -1
    fun type(model: ErrorUiModel): Int = -1
    // to be added with other search result components

    fun createViewHolder(view: View, type: Int): BaseViewHolder<BaseVisitable>
}