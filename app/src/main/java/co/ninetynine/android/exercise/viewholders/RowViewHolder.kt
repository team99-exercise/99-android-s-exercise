package co.ninetynine.android.exercise.viewholders

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import co.ninetynine.android.exercise.databinding.LayoutRowCheckboxBinding
import co.ninetynine.android.exercise.databinding.LayoutRowRadioBinding
import co.ninetynine.android.exercise.databinding.LayoutRowTextBinding
import co.ninetynine.android.exercise.listeners.ViewInteractionListener
import co.ninetynine.android.exercise.model.Row
import co.ninetynine.android.exercise.model.RowCheckbox
import co.ninetynine.android.exercise.model.RowRadio
import co.ninetynine.android.exercise.model.RowText

class RowViewHolder(
        private val binding: ViewBinding,
        private val listener: ViewInteractionListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(row: Row<*>) {
        when {
            row is RowCheckbox && binding is LayoutRowCheckboxBinding -> {
                binding.checkbox.text = row.title
                binding.checkbox.isChecked = row.valueForDisplay
                binding.checkbox.setOnClickListener {
                    row.saveChosenValue(binding.checkbox.isChecked)
                    if (row.hasDependantFormElements) {
                        listener.onInteract()
                    }
                }
            }
            row is RowRadio && binding is LayoutRowRadioBinding -> {

                val values: MutableList<String> = mutableListOf()
                values.addAll(row.options.map { it.label })
                var selected = values.indexOf(row.valueForDisplay.label)

                binding.title.text = row.title

                binding.radioGroup.apply {
                    adapter = ArrayAdapter(binding.root.context, android.R.layout.simple_spinner_item, values)
                    setSelection(selected)
                    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            if (selected != position) {
                                selected = position
                                row.saveChosenValue(row.options[position])
                                if (row.hasDependantFormElements) {
                                    listener.onInteract()
                                }
                            }
                        }

                        override fun onNothingSelected(parent: AdapterView<*>?) = Unit
                    }
                }
            }
            row is RowText && binding is LayoutRowTextBinding -> {
                binding.title.text = row.title

                binding.editText.isSingleLine = !row.isMultipleLine
                row.valueForDisplay?.let {
                    binding.editText.setText(it)
                }
                binding.editText.doAfterTextChanged {
                    row.saveChosenValue(it.toString())
                    if (row.hasDependantFormElements) {
                        listener.onInteract()
                    }
                }

                binding.placeholder.text = row.placeholder
            }
        }
    }
}