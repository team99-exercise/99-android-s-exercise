package co.ninetynine.android.exercisev2.search.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercisev2.search.databinding.RowSearchItemBinding
import co.ninetynine.android.exercisev2.search.ext.getLayoutInflater
import co.ninetynine.android.exercisev2.search.model.ListingItem

class SearchAdapter(
    private val context: Context
): RecyclerView.Adapter<SearchViewHolder>() {
    private val _searchItems = arrayListOf<ListingItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setSearchItems(searchItems: List<ListingItem>) {
        _searchItems.clear()
        _searchItems.addAll(searchItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = RowSearchItemBinding.inflate(context.getLayoutInflater())
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = getItemAtPositionOrNull(position) ?: return
        holder.bind(item)
    }

    private fun getItemAtPositionOrNull(position: Int) = if (position.isValidPosition()) {
        _searchItems[position]
    } else null

    private fun Int.isValidPosition() = this in 0 until itemCount

    override fun getItemCount() = _searchItems.size
}

class SearchViewHolder(binding: RowSearchItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(listingItem: ListingItem) {
        // TODO()
    }
}
