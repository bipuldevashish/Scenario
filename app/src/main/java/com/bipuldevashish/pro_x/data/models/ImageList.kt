package com.bipuldevashish.pro_x.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

/*
*
* ImageList : This is a model class for the List that we'll be.
* getting from the JSON that's fetched. It contains list of all the MODELS of "ImageItem"
*
* for checking data of individual image , goto---> ImageItem
*
*/
@Parcelize
data class ImageList(
    val page: Int,                  //   shows the current page number
    val per_page: Int,             //    shows the number of photos returned with each page
    val total_results: Int,          //   shows total images including all pages
    val photos: @RawValue List<Photos>    //   to store the actual image list
) : Parcelable