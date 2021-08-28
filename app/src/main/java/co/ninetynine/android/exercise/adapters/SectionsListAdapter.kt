package co.ninetynine.android.exercise.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.ninetynine.android.exercise.R;
import co.ninetynine.android.exercise.model.Section;
import co.ninetynine.android.exercise.viewholders.SectionViewHolder;

public class SectionsListAdapter extends RecyclerView.Adapter<SectionViewHolder> {

    private ArrayList<Section> sections;

    public SectionsListAdapter(ArrayList<Section> sections) {
        this.sections = sections;
    }

    @NonNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SectionViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_section, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SectionViewHolder holder, int position) {
        holder.bind(sections.get(position));
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }
}
