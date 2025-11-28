package com.track.union.application

import android.app.Application
import android.content.SharedPreferences

class UnionApplication:Application() {
    companion object {
        private var prefs: SharedPreferences? = null

        fun getPreferences(): SharedPreferences {
            return prefs ?: throw IllegalStateException("SharedPreferences not initialized")
        }
    }

    override fun onCreate() {
        super.onCreate()
        prefs = getSharedPreferences("u_kofi_prefs", MODE_PRIVATE)
    }
}