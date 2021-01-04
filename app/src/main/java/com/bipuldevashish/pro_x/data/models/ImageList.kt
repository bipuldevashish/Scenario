package com.bipuldevashish.pro_x.data.models

import com.google.gson.annotations.SerializedName

/*
*
* ImageList : This is a model class for the List that we'll be.
* getting from the JSON that's fetched. It contains list of all the MODELS of "ImageItem"
*
* for checking data of individual image , goto---> ImageItem
*
*/

data class ImageList(
    val page: Int,                  //   shows the current page number
    val per_page : Int,             //    shows the number of photos returned with each page
    val total_results: Int,          //   shows total images including all pages
    val photos: List<Photos>    //   to store the actual image list
)

data class Photos(
        @SerializedName("id")
        val id : Int,
        val photographer : String,
        val avg_color : String,
        val liked : Boolean,
        val src: Src
)


data class Src(
        val medium : String,            // to store the medium size url which will be displayed in recycler view
        val large2x : String            // to store the actual size url which will be displayed on full screen
)