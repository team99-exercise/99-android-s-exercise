package co.ninetynine.android.exercise.features

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercise.model.Section

class SectionRecyclerAdapter() : RecyclerView.Adapter<SectionViewHolder>() {

    private val itemList = ArrayList<Section>()

    fun setDatas(list: List<Section>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        return SectionViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}