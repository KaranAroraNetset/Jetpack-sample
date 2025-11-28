package com.track.union.utils

import android.content.SharedPreferences
import androidx.core.content.edit
import com.track.union.application.UnionApplication

object SharedPrefsManager {
    private fun getPrefs(): SharedPreferences {
        return UnionApplication.Companion.getPreferences()
    }
    fun setIsUserLoggedIn(isUserLogin:Boolean){
        getPrefs().edit{
            putBoolean("Is_User_Logged_In",isUserLogin)
        }
    }
    fun getIsUserLoggedIn():Boolean{
        return getPrefs().getBoolean("Is_User_Logged_In",false)
    }
}