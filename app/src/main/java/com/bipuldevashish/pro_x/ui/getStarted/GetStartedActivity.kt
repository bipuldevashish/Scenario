package com.bipuldevashish.pro_x.ui.getStarted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.ActivityGetStartedBinding

class GetStartedActivity : AppCompatActivity() {

    private var _binding: ActivityGetStartedBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityGetStartedBinding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}