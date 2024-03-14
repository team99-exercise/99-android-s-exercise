package com.frenzelts.team99.common.adapter

import android.view.View
import androidx.annotation.LayoutRes
import com.frenzelts.team99.R
import com.frenzelts.team99.common.visitable.ErrorUiModel

class ErrorViewHolder(view: View): BaseViewHolder<ErrorUiModel>(view) {
    override fun bind(element: ErrorUiModel) {

    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.error_view
    }
}