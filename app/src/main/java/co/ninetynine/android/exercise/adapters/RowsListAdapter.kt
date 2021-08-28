package co.ninetynine.android.exercise.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.ninetynine.android.exercise.R;
import co.ninetynine.android.exercise.model.Row;
import co.ninetynine.android.exercise.model.RowType;
import co.ninetynine.android.exercise.viewholders.RowViewHolder;

public class RowsListAdapter extends RecyclerView.Adapter<RowViewHolder> {

    private ArrayList<Row> rows;

    public RowsListAdapter(ArrayList<Row> rows) {
        this.rows = rows;
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        String type = rows.get(position).type;
        View view;
        if (type.equals(RowType.CHECKBOX.value)) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row_checkbox, parent, false);
        } else if (type.equals(RowType.RADIO.value)) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row_radio, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row_text, parent, false);
        }
        return new RowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        holder.bind(rows.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }
}
