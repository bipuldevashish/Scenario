package com.bipuldevashish.pro_x.utils

import android.util.Log
import android.util.Patterns
import android.widget.EditText

object Inputcheck {

    private const val TAG = "Inputcheck"
    fun isNullOrEmpty(et: EditText): Boolean {
        return if (et.text.toString().isEmpty()) {
            et.error = "Field Required"
            et.requestFocus()
            false
        } else true
    }

    fun isPatternMatched(typeEnum: InputTypeEnum, et: EditText): Boolean {
        return when (typeEnum) {
            InputTypeEnum.EMAIL_ADDRESS -> {
                Log.d(TAG, "isPatternMatched: ")
                if (!Patterns.EMAIL_ADDRESS.matcher(et.text.toString()).matches()) {
                    et.error = "Please Enter a valid Email"
                    et.requestFocus()
                    false
                } else true
            }
            InputTypeEnum.PHONE -> {
                if (!Patterns.PHONE.matcher(et.text.toString()).matches()) {
                    et.error = "Please Enter a valid Email"
                    et.requestFocus()
                    false
                }else true
            }
        }
    }
}