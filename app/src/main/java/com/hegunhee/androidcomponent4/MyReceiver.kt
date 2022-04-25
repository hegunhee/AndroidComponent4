package com.hegunhee.androidcomponent4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    companion object {
        const val MyAction = "com.hegunhee.androidcomponent4.ACTION_MY_BROADCAST"
    }

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_POWER_CONNECTED -> {
                Toast.makeText(context, "전원 연결", Toast.LENGTH_SHORT).show()
            }
            MyAction -> {
                Toast.makeText(context, "방송", Toast.LENGTH_SHORT).show()
            }
        }

    }
}