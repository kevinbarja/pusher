package com.icorebiz.pusher

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.iid.FirebaseInstanceId
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        info("Firebase: Token: ${FirebaseInstanceId.getInstance().token}")
    }
}
