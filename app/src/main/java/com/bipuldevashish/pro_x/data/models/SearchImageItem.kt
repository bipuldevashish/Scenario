package com.bipuldevashish.pro_x.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class SearchImageItem(

        @SerializedName("total_results") val total_results : Int = 0,
        @SerializedName("photos") val photos: List<ImageList.Photos> = emptyList(),
        val nextPage : Int? = null
    )
