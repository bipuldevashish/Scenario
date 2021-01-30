package com.bipuldevashish.pro_x.ui.signup

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.FragmentSignupBinding
import com.bipuldevashish.pro_x.ui.main.MainActivity
import com.bipuldevashish.pro_x.utils.InputTypeEnum
import com.bipuldevashish.pro_x.utils.Inputcheck.areFieldsEqual
import com.bipuldevashish.pro_x.utils.Inputcheck.isNullOrEmpty
import com.bipuldevashish.pro_x.utils.Inputcheck.isPatternMatched
import com.bipuldevashish.pro_x.utils.UtilHelper
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_signup.*


private const val TAG = "SignUpFragment"

class SignUpFragment : Fragment(R.layout.fragment_signup) {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    private var mAuth: FirebaseAuth? = null
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var progressDailog: ProgressDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSignupBinding.bind(view)
        mAuth = FirebaseAuth.getInstance()
        mDatabaseReference = FirebaseDatabase.getInstance().reference

        setupViews()
    }

    private fun setupViews() {
        binding.linearlayoutAlreadyHaveaccount.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignup2ToLoginFragment2()
            findNavController().navigate(action)
        }

        binding.signupBtnRegister.setOnClickListener {
            progressDailog = UtilHelper.showProgressDialog(activity, "Signing Up")!!
            if (inputCheck()) {
                performSignUp()
            }else{
                if (progressDailog.isShowing){
                    progressDailog.dismiss()
                }
            }
        }
    }

    private fun inputCheck(): Boolean {
        if (isNullOrEmpty(etNameRegister) && isNullOrEmpty(etEmailRegister) && isPatternMatched(
                        InputTypeEnum.EMAIL_ADDRESS,
                        etEmailRegister
                ) && isNullOrEmpty(etPasswordRegister) &&  isNullOrEmpty(
                        etConfirmPasswordRegister
                ) && areFieldsEqual(etPasswordRegister, etConfirmPasswordRegister)) {
            Log.d(TAG, "inputCheck: condition passed")
            return true
        }
        return false
    }

    private fun performSignUp() {
        mAuth?.createUserWithEmailAndPassword(
                etEmailRegister.text.toString(),
                etPasswordRegister.text.toString()
        )
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                        if (progressDailog.isShowing) {
                            progressDailog.dismiss()
                        }
                    Log.d(ContentValues.TAG, "createUserWithEmail:success")
                    addDataToFirebase(etNameRegister.text.toString(), etEmailRegister.text.toString())
                    Toast.makeText(
                            context, "Sign up success.",
                            Toast.LENGTH_SHORT
                    ).show()
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
                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                            context, "Sign up failure.",
                            Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    private fun addDataToFirebase(name : String, email: String) {

        val userData = HashMap<String, String>()
        userData["Name"] = name
        userData["Email"] = email
        userData["D_O_B"] = ""
        userData["Place"] = ""

        mAuth?.currentUser?.let { mDatabaseReference?.child("Users")?.child(it.uid) }?.setValue(userData)

    }

    private fun updateUI(user: FirebaseUser?) {

    }
}