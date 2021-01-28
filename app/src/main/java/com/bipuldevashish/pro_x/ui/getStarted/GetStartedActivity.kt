package com.bipuldevashish.pro_x.ui.getStarted

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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