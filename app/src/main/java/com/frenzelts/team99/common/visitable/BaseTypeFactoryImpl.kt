package com.frenzelts.team99.common.visitable

import android.view.View
import com.frenzelts.team99.common.adapter.BaseViewHolder
import com.frenzelts.team99.common.adapter.ErrorViewHolder
import com.frenzelts.team99.common.adapter.LoadingViewHolder

open class BaseTypeFactoryImpl: BaseTypeFactory {

    override fun type(model: LoadingUiModel): Int {
        return LoadingViewHolder.LAYOUT
    }
    override fun type(model: ErrorUiModel): Int {
        return ErrorViewHolder.LAYOUT
    }

    @Suppress("UNCHECKED_CAST")
    override fun createViewHolder(view: View, type: Int): BaseViewHolder<BaseVisitable> {
        return when(type) {
            LoadingViewHolder.LAYOUT -> LoadingViewHolder(view)
            ErrorViewHolder.LAYOUT -> ErrorViewHolder(view)
            else -> LoadingViewHolder(view)
        } as BaseViewHolder<BaseVisitable>
    }
}