package com.bipuldevashish.pro_x.ui.getStartedFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.FragmentGetStartedBinding


class GetStartedFragment : Fragment(R.layout.fragment_get_started) {

    private var _binding: FragmentGetStartedBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGetStartedBinding.bind(view)

        binding.loginBtn.setOnClickListener {
            val action = GetStartedFragmentDirections.actionGetStartedFragmentToLoginFragment2()
            findNavController().navigate(action)
        }

        binding.signupBtn.setOnClickListener {
            val action = GetStartedFragmentDirections.actionGetStartedFragmentToSignup2()
            findNavController().navigate(action)
        }
    }
}