package com.bipuldevashish.pro_x.ui.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.FragmentSignupBinding

class SignUpFragment : Fragment(R.layout.fragment_signup) {

    private var _binding : FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSignupBinding.bind(view)

        binding.linearlayoutAlreadyHaveaccount.setOnClickListener {
                val action = SignUpFragmentDirections.actionSignup2ToLoginFragment2()
                findNavController().navigate(action)
        }
    }
}