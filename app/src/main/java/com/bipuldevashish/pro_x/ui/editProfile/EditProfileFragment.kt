package com.bipuldevashish.pro_x.ui.editProfile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.FragmentEditProfileBinding
import com.google.firebase.auth.FirebaseAuth

class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {

    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!
    private var mAuth: FirebaseAuth? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentEditProfileBinding.bind(view)

    }
}