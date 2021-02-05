package com.bipuldevashish.pro_x.ui.profile

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.FragmentProfileBinding
import com.bipuldevashish.pro_x.ui.getStarted.GetStartedActivity
import com.bipuldevashish.pro_x.utils.UtilHelper
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private var mAuth: FirebaseAuth? = null
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var progressDailog : ProgressDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        _binding = FragmentProfileBinding.bind(view)
        mAuth = FirebaseAuth.getInstance()
        mDatabaseReference=
            mAuth?.currentUser?.let {
                FirebaseDatabase.getInstance().reference.child("Users").child(
                    it.uid)
            }!!
        setupViews()

    }

    private fun setupViews() {

        binding.tvEmailAddress.text = mAuth?.currentUser?.email.toString()

        binding.settingsMenu.setOnClickListener {
            val popup = PopupMenu(context, settingsMenu)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.settings_menu, popup.menu)
            popup.show()
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.editProfile -> {
                        // do your code
                        val action = ProfileFragmentDirections.actionProfileToEditProfileFragment()
                        findNavController().navigate(action)
                        true
                    }
                    R.id.logout -> {
                        // do your code
                        progressDailog = UtilHelper.showProgressDialog(activity, "Signing Out")!!
                        mAuth?.signOut()
                        progressDailog.dismiss()
                        val intent = Intent(context, GetStartedActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                        true
                    }
                    else -> false

                }
            }

            binding.tvEmailAddress.text = mAuth?.currentUser?.email.toString()

            settingsMenu.setOnClickListener {
                mAuth?.signOut()
                val intent = Intent(context, GetStartedActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        }
    }
}