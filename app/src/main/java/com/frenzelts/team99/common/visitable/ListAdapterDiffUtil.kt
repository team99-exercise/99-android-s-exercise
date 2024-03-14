package com.frenzelts.team99.common.visitable

import androidx.recyclerview.widget.DiffUtil
import com.frenzelts.team99.common.visitable.BaseTypeFactory
import com.frenzelts.team99.common.visitable.Visitable

class ListAdapterDiffUtil: DiffUtil.ItemCallback<Visitable<BaseTypeFactory>>() {
    override fun areItemsTheSame(
        oldItem: Visitable<BaseTypeFactory>,
        newItem: Visitable<BaseTypeFactory>
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Visitable<BaseTypeFactory>,
        newItem: Visitable<BaseTypeFactory>
    ): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}