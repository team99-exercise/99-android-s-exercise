package co.ninetynine.android.exercise.features

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import co.ninetynine.android.exercise.base.BaseViewHolder
import co.ninetynine.android.exercise.databinding.ItemRowTextBinding
import co.ninetynine.android.exercise.model.Row

class RowTextViewHolder(private val itemBinding: ItemRowTextBinding) :
    BaseViewHolder(itemBinding.root) {

    companion object {
        fun create(parent: ViewGroup): RowTextViewHolder {
            val binding =
                ItemRowTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RowTextViewHolder(binding)
        }
    }

    fun bind(item: Row) {
        if (item.title.isNullOrBlank()) {
            itemBinding.tvTitle.visibility = View.GONE
        } else {
            itemBinding.tvTitle.visibility = View.VISIBLE
            itemBinding.tvTitle.text = item.title
        }
        itemBinding.edtInput.hint = item.placeholder
        itemBinding.edtInput.setText(item.value?.toString() ?: "")
        //TODO to use debounce
        itemBinding.edtInput.doAfterTextChanged {
            item.value = it.toString()
        }
    }
}