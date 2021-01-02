package com.bipuldevashish.pro_x.ui.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.data.local.ImageDatabase
import com.bipuldevashish.pro_x.data.repository.ImageRepository
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var viewmodel: MainViewmodel

    private val TAG = "HomeActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.elevation ?:0
        val navView:BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.navigation_home
                )
        )

        val imageRepository = ImageRepository(ImageDatabase.getDatabase(this))


    }
}