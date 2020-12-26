package com.bipuldevashish.pro_x.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bipuldevashish.pro_x.data.models.ImageItem

@Database(entities = [ImageItem::class], version = 1, exportSchema = false)

abstract class ImageDatabase : RoomDatabase(){

        //to create or access an instance of ImageDao
        abstract fun imageDao() : ImageDao

        /*
            ImageData should have only one instance to avoid work load
         */

        companion object{
        @Volatile
        private var INSTANCE : ImageDatabase? = null

            fun getDatabase(context: Context) : ImageDatabase{
                val tempInstance = INSTANCE

            /*
            check for instance if already exists,else create one
             */
                if (tempInstance != null){
                    return tempInstance
                }

                synchronized(this){
                    val instance = Room.databaseBuilder(    //  Database Builder : build's the database
                        context.applicationContext,         //  Provide the Context
                        ImageDatabase::class.java,          //  Table format for Database
                        "image_database"             //  Name for the Database
                    ).build()                               //  Build fun. to execute the builder.
                    INSTANCE = instance                     //  Assigning local var. instance to INSTANCE
                    return instance                         //  Returning the instance
                }
            }
        }
}