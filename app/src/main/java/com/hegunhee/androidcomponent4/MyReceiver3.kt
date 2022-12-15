package com.hegunhee.androidcomponent4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver3 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){
            ReceiverActivity.MyAction -> {
                Log.d("방송","priority 3")
            }
        }
    }
}