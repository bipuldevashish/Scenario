package com.bipuldevashish.pro_x.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonObject
import kotlinx.android.extensions.ContainerOptions

@Entity(
            tableName = "image_table"
)

data class ImageItem (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo val id: Int,
        @ColumnInfo val avg_color : String,
        @ColumnInfo val liked : Boolean,
        @ColumnInfo val photographer : String,
        @ColumnInfo val medium : String,
        @ColumnInfo val large2x : String
        )
