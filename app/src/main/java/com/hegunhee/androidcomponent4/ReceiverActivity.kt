package com.hegunhee.androidcomponent4

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hegunhee.androidcomponent4.databinding.ActivityReceiverBinding

class ReceiverActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReceiverBinding
    private lateinit var receiver1 : BroadcastReceiver
    private lateinit var receiver2 : BroadcastReceiver
    private lateinit var receiver3 : BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiverBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        initViews()
        receiver1 = MyReceiver1()
        receiver2 = MyReceiver2()
        receiver3 = MyReceiver3()

    }
    private fun initViews() {
        binding.register.setOnClickListener {
            Intent(MyAction).also{
                sendOrderedBroadcast(it,"")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        IntentFilter(Intent.ACTION_POWER_CONNECTED)
        IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(MyAction)
            registerReceiver(receiver1,this)
            registerReceiver(receiver2,this)
            registerReceiver(receiver3,this)
        }

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver1)
        unregisterReceiver(receiver2)
        unregisterReceiver(receiver3)
    }

    companion object {
        const val MyAction = "com.hegunhee.androidcomponent4.ACTION_MY_BROADCAST"
    }


}