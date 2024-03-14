package com.frenzelts.team99.common.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.frenzelts.team99.common.visitable.BaseVisitable
import java.util.Objects

abstract class BaseViewHolder<T: BaseVisitable>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(element: T)
    open fun bind(element: T, payloads: List<Objects>) = bind(element)
}