package co.ninetynine.android.exercise.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import co.ninetynine.android.exercise.R;
import co.ninetynine.android.exercise.adapters.RowsListAdapter;
import co.ninetynine.android.exercise.model.Section;

public class SectionViewHolder extends RecyclerView.ViewHolder {
    private final View itemView;

    public SectionViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public void bind(Section section) {
        TextView header = itemView.findViewById(R.id.header);
        RecyclerView rows = itemView.findViewById(R.id.rows);
        TextView footer = itemView.findViewById(R.id.footer);

        if (section.hasTitle()) {
            header.setText(section.title);
        } else {
            header.setVisibility(View.GONE);
        }

        rows.setAdapter(new RowsListAdapter(section.rows));

        if (section.hasFooter()) {
            footer.setText(section.footer);
        } else {
            footer.setVisibility(View.GONE);
        }
    }
}
