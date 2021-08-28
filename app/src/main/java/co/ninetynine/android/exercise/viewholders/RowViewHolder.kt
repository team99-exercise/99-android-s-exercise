package co.ninetynine.android.exercise.viewholders

import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import co.ninetynine.android.exercise.databinding.LayoutRowCheckboxBinding
import co.ninetynine.android.exercise.databinding.LayoutRowRadioBinding
import co.ninetynine.android.exercise.databinding.LayoutRowTextBinding
import co.ninetynine.android.exercise.model.Row
import co.ninetynine.android.exercise.model.RowCheckbox
import co.ninetynine.android.exercise.model.RowRadio
import co.ninetynine.android.exercise.model.RowText
import co.ninetynine.android.exercise.model.FormOption

class RowViewHolder(private val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(row: Row<*>) {
        when {
            row is RowCheckbox && binding is LayoutRowCheckboxBinding -> {
                binding.checkbox.text = row.title
            }
            row is RowRadio && binding is LayoutRowRadioBinding -> {
                val selectValue = row.value?.asString
                val options = row.options
                var option: FormOption
                binding.title.text = row.title
                for (index in options.indices) {
                    option = options[index]
                    val radioButton = RadioButton(binding.root.context)
                    radioButton.id = index
                    radioButton.text = option.label
                    selectValue?.let {
                        radioButton.isChecked = selectValue == option.value!!.asString
                    }
                    binding.radioGroup.addView(radioButton)
                }
            }
            row is RowText && binding is LayoutRowTextBinding -> {
                binding.title.text = row.title
                binding.editText.isSingleLine = !row.isMultipleLine
                binding.placeholder.text = row.placeholder
            }
        }
    }
}