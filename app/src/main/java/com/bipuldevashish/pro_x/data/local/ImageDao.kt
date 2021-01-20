package com.bipuldevashish.pro_x.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface ImageDao {
            // on inserting new data if conflict occurs it resolves the issue
            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun addImage(imageItem : ImageItem) : Long

            
}