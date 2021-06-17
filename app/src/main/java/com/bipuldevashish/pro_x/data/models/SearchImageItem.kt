package com.bipuldevashish.pro_x.data.models

import com.google.gson.annotations.SerializedName

data class SearchImageItem(

        @SerializedName("total_results") val total_results : Int = 0,
        @SerializedName("photos") val photos: List<Photos> = emptyList(),
        val nextPage : Int? = null
)
