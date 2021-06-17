package com.bipuldevashish.pro_x.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Src (
    val medium: String,            // to store the medium size url which will be displayed in recycler view
    val large2x: String,            // to store the actual size url which will be displayed on full screen
    val portrait: String
        ): Parcelable