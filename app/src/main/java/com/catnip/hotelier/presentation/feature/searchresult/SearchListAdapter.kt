package com.catnip.hotelier.presentation.feature.searchresult

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.catnip.hotelier.R
import com.catnip.hotelier.base.core.ItemInflater
import com.catnip.hotelier.databinding.ItemPlaceBinding
import com.catnip.hotelier.presentation.model.Place
import com.catnip.hotelier.utils.formatDecimalSeparator
import com.catnip.hotelier.utils.toCurrencyFormat
import com.catnip.hotelier.utils.toPx

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class SearchListAdapter(private val onItemClicked: (Place) -> Unit) :
    RecyclerView.Adapter<PlaceItemViewHolder>() {

    private val dataDiffer =
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<Place>() {
                override fun areItemsTheSame(
                    oldItem: Place,
                    newItem: Place
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Place,
                    newItem: Place
                ): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }
            }
        )

    fun submitData(newList: List<Place>) {
        dataDiffer.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlaceItemViewHolder(
        ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onItemClicked = onItemClicked
    )

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: PlaceItemViewHolder, position: Int) {
        holder.inflate(dataDiffer.currentList[position])
    }
}

class PlaceItemViewHolder(
    private val binding: ItemPlaceBinding,
    private val onItemClicked: (Place) -> Unit
) : ViewHolder(binding.root), ItemInflater<Place> {
    override fun inflate(data: Place) {
        binding.root.setOnClickListener { onItemClicked.invoke(data) }
        binding.tvPlaceName.text = data.projectName
        binding.tvPlaceDesc.text = binding.root.context.getString(
            R.string.format_place_desc,
            data.address?.streetName,
            data.address?.district,
            data.category,
            data.completedAt,
            data.tenure.toString()
        )
        binding.tvPlaceRoomDesc.text = binding.root.context.getString(
            R.string.format_place_room_desc,
            data.attributes?.bedrooms.toString(),
            data.attributes?.bathrooms.toString(),
            data.attributes?.price?.formatDecimalSeparator()
        )
        binding.tvPlacePrice.text = binding.root.context.getString(
            R.string.format_place_price,
            data.attributes?.price?.toCurrencyFormat()
        )
        binding.ivPlace.load(data.photo) {
            transformations(
                RoundedCornersTransformation(
                    topLeft = 8.toPx().toFloat(),
                    topRight = 8.toPx().toFloat(),
                    bottomLeft = 8.toPx().toFloat(),
                    bottomRight = 8.toPx().toFloat()
                )
            )
            scale(Scale.FILL)
            placeholder(R.drawable.image_placeholder)
            error(R.drawable.image_placeholder)
            crossfade(true)
        }
    }
}
