package com.bipuldevashish.pro_x.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.data.models.ImageList
import com.bipuldevashish.pro_x.databinding.ImageItemRvBinding
import com.squareup.picasso.Picasso

private const val TAG = "SearchImageAdapter"

class SearchImageAdapter(private val listner: OnitemClickListner) :
    PagingDataAdapter<ImageList.Photos, SearchImageAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    inner class PhotoViewHolder(private val binding: ImageItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
                binding.root.setOnClickListener{
                    val position = bindingAdapterPosition
                    if (position != RecyclerView.NO_POSITION ){
                            val item = getItem(position)
                            if (item != null){
                                listner.onItemClick(item)
                            }
                    }
                }
        }

        fun bind(photo: ImageList.Photos) {
            binding.apply {
                Picasso.get()
                    .load(photo.src.medium)
                    .error(R.drawable.ic_round_erro_24)
                    .into(imgItem)
            }
        }
    }

    interface OnitemClickListner {
        fun onItemClick(photo: ImageList.Photos)
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<ImageList.Photos>() {
            override fun areItemsTheSame(
                oldItem: ImageList.Photos,
                newItem: ImageList.Photos
            ) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ImageList.Photos,
                newItem: ImageList.Photos
            ) =
                oldItem == newItem

        }
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        Log.d(TAG, "onBindViewHolder: ${currentItem?.src?.medium}")
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ImageItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }
}



