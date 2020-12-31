package com.bipuldevashish.pro_x.ui.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.data.local.ImageDatabase
import com.bipuldevashish.pro_x.data.repository.ImageRepository

class MainActivity : AppCompatActivity() {

    lateinit var viewmodel: MainViewmodel

    private val TAG = "HomeActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageRepository = ImageRepository(ImageDatabase.getDatabase(this))


    }
}