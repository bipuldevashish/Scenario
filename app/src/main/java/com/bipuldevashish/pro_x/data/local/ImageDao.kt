package com.bipuldevashish.pro_x.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.bipuldevashish.pro_x.data.models.ImageItem

@Dao
interface ImageDao {
            // on inserting new data if conflict occurs it resolves the issue
            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun addImage(imageItem : ImageItem) : Long
}