package com.bipuldevashish.pro_x.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bipuldevashish.pro_x.GetStartedFragment
import com.bipuldevashish.pro_x.ui.getStarted.GetStartedActivity
import com.bipuldevashish.pro_x.utils.Authentication.isUserAuthenticated
import com.bipuldevashish.pro_x.ui.main.MainActivity
import com.bipuldevashish.pro_x.utils.UtilHelper

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHandler()
    }

    private fun setHandler() {
        Handler().postDelayed({
            if (isUserAuthenticated() && !UtilHelper.isFirstTimeAppOpened(this)) {
                val i = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(i)
                finish()
            } else {
                val i = Intent(this@SplashActivity, GetStartedActivity::class.java)
                startActivity(i)
                finish()
            }
        }, 2 * 1000.toLong())
    }

}
