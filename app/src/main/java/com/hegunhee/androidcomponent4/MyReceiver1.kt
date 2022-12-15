package com.hegunhee.androidcomponent4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.hegunhee.androidcomponent4.ReceiverActivity.Companion.MyAction

class MyReceiver1 : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_POWER_CONNECTED -> {
                Toast.makeText(context, "전원 연결", Toast.LENGTH_SHORT).show()
            }
            MyAction -> {
                Log.d("방송","priority 1")
            }
        }

    }
}