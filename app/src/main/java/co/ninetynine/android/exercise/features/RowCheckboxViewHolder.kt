package co.ninetynine.android.exercise.features

import android.view.LayoutInflater
import android.view.ViewGroup
import co.ninetynine.android.exercise.base.BaseViewHolder
import co.ninetynine.android.exercise.databinding.ItemRowCheckboxBinding
import co.ninetynine.android.exercise.model.Row

class RowCheckboxViewHolder(private val itemBinding: ItemRowCheckboxBinding) :
    BaseViewHolder(itemBinding.root) {

    companion object {
        fun create(parent: ViewGroup): RowCheckboxViewHolder {
            val binding =
                ItemRowCheckboxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RowCheckboxViewHolder(binding)
        }
    }

    fun bind(item: Row) {
        itemBinding.cbToggle.text = item.title
        itemBinding.cbToggle.isChecked = item.value == true
    }
}