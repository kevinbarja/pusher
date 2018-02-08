package com.icorebiz.pusher

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class FcmInstanceIdService : FirebaseInstanceIdService(), AnkoLogger {

    override fun onTokenRefresh() {
        info("Firebase: Refreshed token: ${FirebaseInstanceId.getInstance().token}")
    }
}