package co.ninetynine.android.exercise.features

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.ninetynine.android.exercise.base.BaseViewHolder
import co.ninetynine.android.exercise.databinding.ItemRowRadioBinding
import co.ninetynine.android.exercise.model.Row
import co.ninetynine.android.exercise.model.event.VisibilityEvent
import org.greenrobot.eventbus.EventBus


class RowRadioViewHolder(private val itemBinding: ItemRowRadioBinding) :
    BaseViewHolder(itemBinding.root) {

    companion object {
        fun create(parent: ViewGroup): RowRadioViewHolder {
            val binding =
                ItemRowRadioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RowRadioViewHolder(binding)
        }
    }

    fun bind(item: Row) {
        if (item.title.isNullOrBlank()) {
            itemBinding.tvTitle.visibility = View.GONE
        } else {
            itemBinding.tvTitle.visibility = View.VISIBLE
            itemBinding.tvTitle.text = item.title
        }
        val data = item.options?.map { it.label } ?: emptyList()
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            itemBinding.root.context,
            android.R.layout.simple_spinner_dropdown_item,
            data
        )
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice)
        itemBinding.spnOptions.adapter = adapter
        itemBinding.spnOptions.setSelection(
            item.options?.map { it.value }?.indexOf(item.value.toString()) ?: 0
        )
        itemBinding.spnOptions.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    item.value = item.options?.get(position)?.value
                    EventBus.getDefault().post(
                        VisibilityEvent(
                            item.key ?: "",
                            item.options?.get(position)?.value ?: ""
                        )
                    )
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
    }
}