package com.frenzelts.team99.common.adapter

import android.view.View
import androidx.annotation.LayoutRes
import com.frenzelts.team99.R
import com.frenzelts.team99.common.visitable.LoadingUiModel

class LoadingViewHolder(view: View): BaseViewHolder<LoadingUiModel>(view) {
    override fun bind(element: LoadingUiModel) {

    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.loading_view
    }
}