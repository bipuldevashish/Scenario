package com.bipuldevashish.pro_x.data.models

import com.google.gson.annotations.SerializedName

data class PhotoDetails(
        @field:SerializedName("id") val id: Long,
        @field:SerializedName("avg_color") val avg_color: String,
        @field:SerializedName("photographer") val photographer: String,
        @field:SerializedName("large2x") val large2x: String,
        @field:SerializedName("medium") val medium: String,
) {
}