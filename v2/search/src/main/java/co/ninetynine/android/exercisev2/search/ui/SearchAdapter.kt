package co.ninetynine.android.exercisev2.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercisev2.search.databinding.RowSearchItemBinding
import co.ninetynine.android.exercisev2.search.model.ListingItem
import com.bumptech.glide.Glide

class SearchAdapter : ListAdapter<ListingItem, SearchViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(RowSearchItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<ListingItem>() {
            override fun areItemsTheSame(oldItem: ListingItem, newItem: ListingItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListingItem, newItem: ListingItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class SearchViewHolder(private val binding: RowSearchItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val separator = Typography.middleDot
    fun bind(listingItem: ListingItem) {
        binding.tvProjectName.text = listingItem.projectName
        binding.tvAddress.text =
            "${listingItem.address.streetName}  $separator  ${listingItem.address.district}"
        binding.tvCategroyYearAndTenure.text =
            "${listingItem.category}  $separator  ${listingItem.completedAt}  $separator  ${listingItem.tenure} yrs"
        binding.tvBedBathTenure.text =
            "${listingItem.attributes.bedrooms} Beds  ${Typography.middleDot}  ${listingItem.attributes.bathrooms} Baths  ${Typography.middleDot}  ${listingItem.attributes.areaSize} sqft"
        binding.tvProjectName.text = listingItem.projectName
        binding.tvProjectName.text = listingItem.projectName
        binding.tvPrice.text = "${Typography.dollar}${listingItem.attributes.price}/mo"
        Glide.with(binding.root).load(listingItem.photoUrl).into(binding.ivPhoto)
    }
}
