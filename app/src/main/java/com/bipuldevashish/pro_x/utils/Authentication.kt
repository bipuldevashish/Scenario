package com.bipuldevashish.pro_x.utils

import com.google.firebase.auth.FirebaseAuth

object Authentication {
    fun isUserAuthenticated(): Boolean {
        return FirebaseAuth.getInstance().currentUser!=null
    }
}