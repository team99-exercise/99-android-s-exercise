package com.frenzelts.team99.search.view.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.frenzelts.team99.R

object SearchItemDecoration: ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val resources = view.resources
        when(parent.getChildAdapterPosition(view)) {
            0 -> {
                outRect.top = resources.getDimensionPixelOffset(R.dimen.search_result_margin)
                outRect.bottom = resources.getDimensionPixelOffset(R.dimen.search_result_margin) / 2
            }
            state.itemCount - 1 -> {
                outRect.top = resources.getDimensionPixelOffset(R.dimen.search_result_margin) / 2
                outRect.bottom = resources.getDimensionPixelOffset(R.dimen.search_result_margin)
            }
            else -> {
                outRect.top = resources.getDimensionPixelOffset(R.dimen.search_result_margin) / 2
                outRect.bottom = resources.getDimensionPixelOffset(R.dimen.search_result_margin) / 2
            }
        }
        outRect.left = resources.getDimensionPixelOffset(R.dimen.search_result_margin)
        outRect.right = resources.getDimensionPixelOffset(R.dimen.search_result_margin)
    }
}