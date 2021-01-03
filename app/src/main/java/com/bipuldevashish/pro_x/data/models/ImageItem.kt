package com.bipuldevashish.pro_x.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
            tableName = "image_table"
)

class ImageItem (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo val id: Long,
        @ColumnInfo val url: String,
        @ColumnInfo val large: String,
        @ColumnInfo val medium: String
        )
