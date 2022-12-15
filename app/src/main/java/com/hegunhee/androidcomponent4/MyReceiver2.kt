package com.hegunhee.androidcomponent4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.hegunhee.androidcomponent4.ReceiverActivity.Companion.MyAction

class MyReceiver2 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){
            MyAction -> {
                Log.d("방송","priority 2")
            }
        }
    }
}