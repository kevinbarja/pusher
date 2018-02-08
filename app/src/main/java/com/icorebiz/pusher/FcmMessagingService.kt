package com.icorebiz.pusher

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import android.content.Intent
import org.jetbrains.anko.warn


class FcmMessagingService : FirebaseMessagingService(), AnkoLogger {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        info("Firebase: onMessageReceived")
        if (remoteMessage != null) {
            val data = remoteMessage.data["data"]
            if (data != null){
                sendBroadcast(data)
            }else{
                warn("Firebase: Data is null")
            }
        }else{
            warn("Firebase: Remote message is null")
        }
    }

    private fun sendBroadcast(data: String){
        val intent = Intent()
        intent.setClassName(Constant.PACKAGE_NAME, Constant.MESSAGING_RECEIVER)
        intent.action = Constant.MESSAGING_ACTION
        intent.putExtra("data", data)
        sendBroadcast(intent)
        info("Firebase: Broadcast sent")
    }
}