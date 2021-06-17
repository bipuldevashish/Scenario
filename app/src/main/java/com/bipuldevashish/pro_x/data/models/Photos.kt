package com.bipuldevashish.pro_x.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Photos (
    val id: Int,
    val width: Int,
    val height: Int,
    val photographer: String,
    val avg_color: String,
    val liked: Boolean,
    val src: @RawValue Src
        ): Parcelable