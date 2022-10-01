package co.ninetynine.android.exercisev2.search.ui

import android.icu.number.NumberFormatter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercisev2.search.databinding.RowSearchItemBinding
import co.ninetynine.android.exercisev2.search.model.Address
import co.ninetynine.android.exercisev2.search.model.ListingItem
import com.bumptech.glide.Glide
import java.text.DecimalFormat
import java.util.*

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
        binding.tvAddress.text = formatAddress(listingItem.address)
        binding.tvCategroyYearAndTenure.text = formatCategoryAndTenure(listingItem)
        binding.tvBedBathSize.text = formatBedBathSize(listingItem)
        binding.tvProjectName.text = listingItem.projectName
        binding.tvPrice.text = formatPrice(listingItem)
        Glide.with(binding.root).load(listingItem.photoUrl).into(binding.ivPhoto)
    }

    private fun formatPrice(listingItem: ListingItem): String {
        val decimalFormat = DecimalFormat("#,###")
        return "${Typography.dollar}${decimalFormat.format(listingItem.attributes.price)}/mo"
    }


    private fun formatBedBathSize(listingItem: ListingItem): String {
        val decimalFormat = DecimalFormat("#,###")
        return "${listingItem.attributes.bedrooms} Beds" +
                "  ${Typography.middleDot}  " +
                "${listingItem.attributes.bathrooms} Baths" +
                "  ${Typography.middleDot}  " +
                "${decimalFormat.format(listingItem.attributes.areaSize)} sqft"
    }

    private fun formatCategoryAndTenure(listingItem: ListingItem) =
        "${listingItem.category}  $separator  ${listingItem.completedAt}  $separator  ${listingItem.tenure} yrs"

    private fun formatAddress(address: Address) =
        "${address.streetName}  $separator  ${address.district}"
}
