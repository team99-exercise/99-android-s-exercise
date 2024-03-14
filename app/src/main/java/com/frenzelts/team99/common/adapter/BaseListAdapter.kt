package com.frenzelts.team99.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.frenzelts.team99.common.visitable.BaseVisitable
import com.frenzelts.team99.common.visitable.BaseTypeFactory
import com.frenzelts.team99.common.visitable.ListAdapterDiffUtil
import com.frenzelts.team99.common.visitable.Visitable
import kotlin.Exception

class BaseListAdapter(
    private val typeFactory: BaseTypeFactory,
): ListAdapter<Visitable<BaseTypeFactory>, BaseViewHolder<*>>(ListAdapterDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return typeFactory.createViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        try {
            val item = getItem(position)
            (holder as? BaseViewHolder<BaseVisitable>)?.bind(item)
        } catch (_: Exception) { }
    }

    override fun getItemViewType(position: Int): Int {
        return try {
            if(position < 0 || position >= itemCount) {
                LoadingViewHolder.LAYOUT
            } else getItem(position).type(typeFactory)
        } catch (e: Exception) {
            ErrorViewHolder.LAYOUT
        }
    }
}