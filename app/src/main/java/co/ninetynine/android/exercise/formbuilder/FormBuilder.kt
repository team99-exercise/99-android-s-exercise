package co.ninetynine.android.exercise.formbuilder

import android.content.Context
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import co.ninetynine.android.exercise.model.*
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import java.util.*

class FormBuilder(private val context: Context, private val linearLayout: LinearLayout) {

    var resultMap = HashMap<String, JsonElement>()
    var visibleConditionsMap = HashMap<String,ArrayList<HashMap<String, JsonElement>>>()
//    var rowMap = HashMap<String, Row>()

    fun build(page: Page?) {
        for (section in page?.sections!!) {

            addToLinearLayout(buildHeader(section))

            for (row in section.rows) {

                if (section.visibleConditions.size > 0) {
                    visibleConditionsMap[row.key] = section.visibleConditions
                }
                when (row) {
                    is RowRadio -> {
                        addToLinearLayout(buildRadioButton(row, section.isVisible))
                    }
                    is RowCheckbox -> {
                        addToLinearLayout(buildCheckbox(row, section.isVisible, section.rowsForConditions))
                    }
                    is RowText -> {
                        addToLinearLayout(buildEditText(row, section.isVisible))
                    }
                }
            }
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

    private fun buildCheckbox(
        formCheckbox: RowCheckbox,
        visible: Boolean,
        rowsForConditions: HashMap<String, Row<Any>>
    ): View {
        val newBox = CheckBox(context)
        newBox.tag = formCheckbox.key
        newBox.text = formCheckbox.title
        newBox.isChecked = formCheckbox.value.asBoolean

        if (visible) {
            newBox.visibility = View.VISIBLE
        }
        else {
            newBox.visibility = View.GONE
        }

        newBox.setOnCheckedChangeListener { buttonView, isChecked ->
            val tag = buttonView.tag as String
            resultMap[tag] = JsonPrimitive(isChecked)
            if (formCheckbox.hasDependantFormElements) {
                refreshViewElements()
            }
        }

        return newBox
    }

    private fun buildRadioButton(rowRadio: RowRadio, visible: Boolean): View {

        val rg = RadioGroup(context)
        val header = TextView(context)
        rg.orientation = RadioGroup.VERTICAL
        rg.tag = rowRadio.key
        header.text = rowRadio.title
        rg.addView(header)
        if (visible) {
            rg.visibility = View.VISIBLE
        }
        else {
            rg.visibility = View.GONE
        }

        for (formOption in rowRadio.options) {
            val rb = RadioButton(context)
            rb.text = formOption.label
            rb.tag = formOption.value
            rb.isChecked = formOption.value == rowRadio.value
            rg.addView(rb)
        }
        return rg
    }

    private fun buildEditText(rowText: RowText, visible: Boolean): View {
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

        if (visible) {
            textInputLayout.visibility = View.VISIBLE
        }
        else {
            textInputLayout.visibility = View.GONE
        }

        return textInputLayout
    }

    private fun refreshViewElements() {
        val count: Int = linearLayout.childCount
        var v: View? = null
        for (i in 0 until count) {
            v = linearLayout.getChildAt(i)
            val key = v.tag
            if (visibleConditionsMap.containsKey(key)) {
                val conditions = visibleConditionsMap[key]

                if (conditions?.contains(resultMap) == true){
                    Log.d("DEBUG", "Show widget")
                    v.visibility = View.VISIBLE
                }
                else {
                    Log.d("DEBUG", "Hide widget")
                    v.visibility = View.GONE
                }
            }
        }
    }

}