package com.bipuldevashish.pro_x.utils

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.widget.Toast


object UtilHelper {

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    fun isFirstTimeAppOpened(context: Context):Boolean {
        val pref: SharedPreferences = context.getSharedPreferences(
            "ActivityPREF",
            Context.MODE_PRIVATE
        )
        return pref.getBoolean("activity_executed", true)
    }

    fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    fun showProgressDialog(activity: Activity?, message: String?): ProgressDialog? {
        val progressDialog = ProgressDialog(activity)
        progressDialog.setMessage(message)
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog.setCancelable(false)
        progressDialog.show()
        return progressDialog
    }

}