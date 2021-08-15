package co.ninetynine.android.exercise.features

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercise.base.BaseViewHolder
import co.ninetynine.android.exercise.databinding.ItemSectionBinding
import co.ninetynine.android.exercise.model.Section

class SectionViewHolder(private val itemBinding: ItemSectionBinding) :
    BaseViewHolder(itemBinding.root) {

    companion object {
        private var rowRecyclerAdapter: RowRecyclerAdapter? = null
        fun create(parent: ViewGroup): SectionViewHolder {
            val binding =
                ItemSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            //setup recyclerview here, not in bind
            binding.rvRow.setHasFixedSize(true)
            binding.rvRow.isNestedScrollingEnabled = false
            binding.rvRow.layoutManager = LinearLayoutManager(
                binding.root.context, RecyclerView.VERTICAL,
                false
            )
            rowRecyclerAdapter = RowRecyclerAdapter()
            binding.rvRow.adapter = rowRecyclerAdapter
            return SectionViewHolder(binding)
        }
    }

    fun bind(item: Section) {
        if (item.title.isNullOrBlank()) {
            itemBinding.tvTitle.visibility = View.GONE
        } else {
            itemBinding.tvTitle.visibility = View.VISIBLE
            itemBinding.tvTitle.text = item.title
        }
        if (item.footer.isNullOrBlank()) {
            itemBinding.tvFooter.visibility = View.GONE
        } else {
            itemBinding.tvFooter.visibility = View.VISIBLE
            itemBinding.tvFooter.text = item.footer
        }
        item.rows?.let { rowRecyclerAdapter?.setDataList(it) }
    }
}