package com.bipuldevashish.pro_x.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.FragmentProfileBinding
import com.bipuldevashish.pro_x.ui.getStarted.GetStartedActivity
import com.bipuldevashish.pro_x.ui.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private var mAuth: FirebaseAuth? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity?)!!.supportActionBar!!.show()


        _binding = FragmentProfileBinding.bind(view)
        mAuth = FirebaseAuth.getInstance()

        setupViews()

    }

    private fun setupViews() {

        if (mAuth?.currentUser?.email.toString() != null) {
            binding.tvEmailAddress.setText(mAuth?.currentUser?.email.toString())
        }
//        if (mAuth?.currentUser?.displayName.toString() != null) {
//            binding.tvName.setText(mAuth?.currentUser?.displayName.toString())
//        }

        settingsMenu.setOnClickListener{
            mAuth?.signOut()
            val intent = Intent(context, GetStartedActivity::class.java)
            startActivity(intent)
        }
//        settingsMenu.setOnClickListener {
//            fun showPopup(v: View?) {
//                val popup = PopupMenu(context, v)
//                val inflater: MenuInflater = popup.getMenuInflater()
//                inflater.inflate(R.menu.settings_menu, popup.getMenu())
//                popup.show()
//            }
//        }
    }

//    fun onMenuItemClick(item: MenuItem): Boolean {
//        return when (item.getItemId()) {
//            R.id.editProfile -> {
//                // do your code
//                val action = ProfileFragmentDirections.actionProfileToEditProfileFragment()
//                findNavController().navigate(action)
//                true
//            }
//            R.id.logout -> {
//                // do your code
//                mAuth?.signOut()
//                true
//            }
//            else -> false
//        }
//    }

}