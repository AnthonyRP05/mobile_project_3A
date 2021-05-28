package com.example.mobile_project_3a.presentation

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication : Application() {
    lateinit var numCryptoAsked : String
    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
        val appContext: Context?
            get() = context
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}