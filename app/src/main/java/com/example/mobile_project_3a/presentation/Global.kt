package com.example.mobile_project_3a.presentation

import android.app.Application

class Global : Application() {
    companion object {
        @JvmField
        var numCryptoAsked: String = "Default value"
    }
}