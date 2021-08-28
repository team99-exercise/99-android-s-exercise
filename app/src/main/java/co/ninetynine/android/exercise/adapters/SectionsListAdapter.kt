package co.ninetynine.android.exercise.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercise.databinding.LayoutSectionBinding
import co.ninetynine.android.exercise.model.Section
import co.ninetynine.android.exercise.viewholders.SectionViewHolder

class SectionsListAdapter(
        private val sections: ArrayList<Section>
) : RecyclerView.Adapter<SectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            SectionViewHolder(LayoutSectionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false)
            )

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(sections[position])
    }

    override fun getItemCount() = sections.size
}