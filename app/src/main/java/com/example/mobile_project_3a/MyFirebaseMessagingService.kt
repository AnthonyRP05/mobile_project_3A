package com.example.mobile_project_3a

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService(){

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        Log.e("massage", "Message received ... ")
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

        Log.e("token", "New token")
    }
}