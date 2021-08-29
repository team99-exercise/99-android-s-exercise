package co.ninetynine.android.exercise.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercise.databinding.LayoutSectionBinding
import co.ninetynine.android.exercise.listeners.ViewInteractionListener
import co.ninetynine.android.exercise.model.Section
import co.ninetynine.android.exercise.viewholders.SectionViewHolder

class SectionsListAdapter(
        private val sections: ArrayList<Section>
) : RecyclerView.Adapter<SectionViewHolder>() {

    private val displayedSetions: MutableList<Section> = sections.filter { it.isVisible }.toMutableList()

    private val listener = object : ViewInteractionListener {
        override fun onInteract() {
            displayedSetions.clear()
            displayedSetions.addAll(sections.filter { it.isVisible })
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            SectionViewHolder(
                    LayoutSectionBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                    ),
                    listener
            )

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(displayedSetions[position])
    }

    override fun getItemCount() = displayedSetions.size
}