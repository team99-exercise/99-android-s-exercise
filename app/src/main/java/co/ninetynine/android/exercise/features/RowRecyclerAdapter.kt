package co.ninetynine.android.exercise.features

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercise.model.Row

class RowRecyclerAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val itemList = ArrayList<Row>()

    private val VT_RADIO = 1
    private val VT_CHECKBOX = 2
    private val VT_TEXT = 3

    fun setDataList(list: List<Row>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VT_RADIO -> RowRadioViewHolder.create(parent)
            VT_CHECKBOX -> RowCheckboxViewHolder.create(parent)
            else -> RowTextViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RowTextViewHolder -> holder.bind(itemList[position])
            is RowRadioViewHolder -> holder.bind(itemList[position])
            is RowCheckboxViewHolder -> holder.bind(itemList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position].type) {
            "radio" -> VT_RADIO
            "checkbox" -> VT_CHECKBOX
            else -> VT_TEXT
        }
    }

}