package co.ninetynine.android.exercise.viewholders;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.ninetynine.android.exercise.R;
import co.ninetynine.android.exercise.model.FormOption;
import co.ninetynine.android.exercise.model.Row;
import co.ninetynine.android.exercise.model.RowCheckbox;
import co.ninetynine.android.exercise.model.RowRadio;
import co.ninetynine.android.exercise.model.RowText;

public class RowViewHolder extends RecyclerView.ViewHolder {

    private final View itemView;

    public RowViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public void bind(Row row) {
        if (row instanceof RowCheckbox) {
            CheckBox checkBox = itemView.findViewById(R.id.checkbox);
            RowCheckbox rowCheckbox = (RowCheckbox) row;
            checkBox.setText(rowCheckbox.title);
        } else if (row instanceof RowRadio) {
            TextView title = itemView.findViewById(R.id.title);
            RadioGroup radioGroup = itemView.findViewById(R.id.radioGroup);

            RowRadio rowRadio = (RowRadio) row;
            String selectValue = row.value.getAsString();
            ArrayList<FormOption> options = rowRadio.options;
            FormOption option;

            title.setText(rowRadio.title);

            for (int index = 0; index < options.size(); index++) {

                option = options.get(index);

                RadioButton radioButton = new RadioButton(itemView.getContext());
                radioButton.setId(index);
                radioButton.setText(option.label);
                radioButton.setChecked(selectValue.equals(option.value.getAsString()));

                radioGroup.addView(radioButton);
            }
        } else if (row instanceof RowText) {
            TextView title = itemView.findViewById(R.id.title);
            EditText editText = itemView.findViewById(R.id.editText);
            TextView placeholder = itemView.findViewById(R.id.placeholder);

            RowText rowText = (RowText) row;

            title.setText(rowText.title);
            editText.setSingleLine(!rowText.isMultipleLine);
            placeholder.setText(rowText.placeholder);
        }
    }
}
