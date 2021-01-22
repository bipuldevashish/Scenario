package com.bipuldevashish.pro_x.ui.getStartedFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bipuldevashish.pro_x.databinding.FragmentGetStartedBinding


class GetStartedFragment : Fragment() {

    private var _binding: FragmentGetStartedBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGetStartedBinding.bind(view)


    }
}