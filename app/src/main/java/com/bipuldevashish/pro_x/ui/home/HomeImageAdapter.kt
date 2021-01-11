package com.bipuldevashish.pro_x.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.data.models.ImageList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item_rv.view.*

class HomeImageAdapter : RecyclerView.Adapter<HomeImageAdapter.MyViewholder>() {
    private var imageList = emptyList<ImageList.Photos>()
    private val TAG = "HomeImageAdapter"

    class MyViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        return MyViewholder(LayoutInflater.from(parent.context).inflate(R.layout.image_item_rv, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        val currentItem = imageList[position]
        for (item in imageList) {
            Log.d(TAG, "onBindViewHolder: current item value : ${currentItem.src.medium}")
            Picasso.get().load(currentItem.src.medium).into(holder.itemView.imgItem)
        }
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ${imageList.size}")
        return imageList.size
    }

    fun setData(image: List<ImageList.Photos>?) {
        if (image != null) {
            this.imageList = image
        }
        notifyDataSetChanged()

    }
}