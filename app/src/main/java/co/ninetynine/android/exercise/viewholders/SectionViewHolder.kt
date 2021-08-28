package co.ninetynine.android.exercise.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercise.adapters.RowsListAdapter
import co.ninetynine.android.exercise.databinding.LayoutSectionBinding
import co.ninetynine.android.exercise.model.Section

class SectionViewHolder(private val binding: LayoutSectionBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(section: Section) {

        if (section.hasTitle()) {
            binding.header.text = section.title
            binding.footer.visibility = View.VISIBLE
        } else {
            binding.header.visibility = View.GONE
        }

        binding.rows.adapter = RowsListAdapter(section.rows)

        if (section.hasFooter()) {
            binding.footer.text = section.footer
            binding.footer.visibility = View.VISIBLE
        } else {
            binding.footer.visibility = View.GONE
        }
    }
}