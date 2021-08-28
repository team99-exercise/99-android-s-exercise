package co.ninetynine.android.exercise.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercise.databinding.LayoutRowCheckboxBinding
import co.ninetynine.android.exercise.databinding.LayoutRowRadioBinding
import co.ninetynine.android.exercise.databinding.LayoutRowTextBinding
import co.ninetynine.android.exercise.model.Row
import co.ninetynine.android.exercise.model.RowType
import co.ninetynine.android.exercise.viewholders.RowViewHolder

class RowsListAdapter(private val rows: ArrayList<Row<*>>) : RecyclerView.Adapter<RowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int) =
            RowViewHolder(when (rows[position].type) {
                RowType.CHECKBOX.value -> {
                    LayoutRowCheckboxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                }
                RowType.RADIO.value -> {
                    LayoutRowRadioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                }
                else -> {
                    LayoutRowTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                }
            })

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        holder.bind(rows[position])
    }

    override fun getItemViewType(position: Int) = position

    override fun getItemCount() = rows.size
}