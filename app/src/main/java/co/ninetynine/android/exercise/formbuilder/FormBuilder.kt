package co.ninetynine.android.exercise.formbuilder

import android.content.Context
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import co.ninetynine.android.exercise.model.*


class FormBuilder(private val context: Context, private val linearLayout: LinearLayout) {

    private val answerMap: HashMap<String, Any> = HashMap()

    fun build(page: Page?) {
        for (section in page?.sections!!) {

            addToLinearLayout(buildHeader(section))

            for (row in section.rows) {

                when (row) {

                    is RowRadio -> {
                        addToLinearLayout(buildRadioButton(row))
                    }
                    is RowCheckbox -> {
                        addToLinearLayout(buildCheckbox(row))
                    }
                    is RowText -> {
                        addToLinearLayout(buildEditText(row))
                    }
                }
            }

//            when (formObject) {
//                is FormHeader -> {
//                    addToLinearLayout(
//                        buildHeader(formObject),
//                        formObject.params
//                    )
//                }
//                is FormElement -> {
//                    val tag = formObject.tagOrToString
//                    formMap[tag] = formObject
//                    addToLinearLayout(
//                        buildElement(formObject),
//                        formObject.params
//                    )
//                }
//                is FormButton -> {
//                    addToLinearLayout(
//                        buildButton(formObject),
//                        formObject.params
//                    )
//                }
//            }
        }
    }

    // Builders
    private fun buildHeader(section: Section): View {
        val headerTextView =
            TextView(context, null)
        headerTextView.text = section.title
        return headerTextView
    }

    private fun addToLinearLayout(view: View?) {
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 8, 8, 8)
        view?.layoutParams = layoutParams
        linearLayout.addView(view)
    }

    private fun addViewToView(parent: ViewGroup, child: View) {
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        child.layoutParams = layoutParams
        parent.addView(child)
    }

    private fun buildCheckbox(formCheckbox: RowCheckbox): View {
        val newBox = CheckBox(context)
        newBox.tag = formCheckbox.key
        newBox.text = formCheckbox.title
        newBox.isChecked = formCheckbox.value.asBoolean

        newBox.setOnCheckedChangeListener { buttonView, isChecked ->
            val tag = buttonView.tag as String
            answerMap[tag] = isChecked

        }

        return newBox
    }

    private fun buildRadioButton(rowRadio: RowRadio): View {

        val rg = RadioGroup(context)
        val header = TextView(context)
        rg.orientation = RadioGroup.VERTICAL
        rg.tag = rowRadio.key
        header.text = rowRadio.title
        rg.addView(header)

        for (formOption in rowRadio.options) {
            val rb = RadioButton(context)
            rb.text = formOption.label
            rb.tag = formOption.value
            rb.isChecked = formOption.value == rowRadio.value
            rg.addView(rb)
        }
        return rg
    }

    private fun buildEditText(rowText: RowText): View {
        val editText = TextInputEditText(context)
        editText.hint = "hint"
        val editTextParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val textInputLayout = TextInputLayout(context)
        val textInputLayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        textInputLayout.layoutParams = textInputLayoutParams
        textInputLayout.addView(editText, editTextParams)
        textInputLayout.hint = rowText.title
        textInputLayout.tag = rowText.key

        return textInputLayout
    }

    fun changeVisibility() {

    }

}