package com.bipuldevashish.pro_x.ui.login

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.FragmentLoginBinding
import com.bipuldevashish.pro_x.ui.main.MainActivity
import com.bipuldevashish.pro_x.utils.InputTypeEnum
import com.bipuldevashish.pro_x.utils.Inputcheck.isNullOrEmpty
import com.bipuldevashish.pro_x.utils.Inputcheck.isPatternMatched
import com.bipuldevashish.pro_x.utils.UtilHelper
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var mAuth: FirebaseAuth? = null
    lateinit var progressDailog: ProgressDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLoginBinding.bind(view)
        mAuth = FirebaseAuth.getInstance()

        setupViews()

    }

    private fun setupViews() {
        binding.linearlayoutNoaccount.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragment2ToSignup2()
            findNavController().navigate(action)
        }
        binding.loginBtn.setOnClickListener {
            progressDailog = UtilHelper.showProgressDialog(activity, "Logging In")!!
            if (inputCheck()) {
                performLogin()
            }else {
                if (progressDailog.isShowing){
                    progressDailog.dismiss()
                }
            }
        }
    }


    private fun performLogin() {

        val progressDialog = ProgressDialog(activity)

        mAuth?.signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    if (progressDailog.isShowing){
                        progressDailog.dismiss()
                    }
                    Log.d(TAG, "signInWithCustomToken:success")
                    context?.let { UtilHelper.showToast(it, "Authentication success.") }
                    val intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)
                    val user = mAuth?.currentUser
                    updateUI(user)
                    activity?.finish()
                } else {
                    // If sign in fails, display a message to the user.
                    if (progressDailog.isShowing){
                        progressDailog.dismiss()
                    }
                    Log.w(TAG, "signInWithCustomToken:failure", task.exception)
                    context?.let { UtilHelper.showToast(it, "Authentication failed.") }
                    updateUI(null)
                }
            }

    }

    private fun inputCheck(): Boolean {
            if (isNullOrEmpty(etEmail) && isPatternMatched(InputTypeEnum.EMAIL_ADDRESS, etEmail) && isNullOrEmpty(etPassword)){
                return true
            }
        return false
    }


    private fun updateUI(user: FirebaseUser?) {

    }
}