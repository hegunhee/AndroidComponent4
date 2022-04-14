package com.hegunhee.androidcomponent4

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hegunhee.androidcomponent4.databinding.ActivityReceiverBinding

class ReceiverActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReceiverBinding
    private lateinit var mReceiver : BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        mReceiver = MyReceiver()

    }
    private fun initViews() {
        binding.register.setOnClickListener {
            Intent(MyReceiver.MyAction).also{
                sendBroadcast(it)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(MyReceiver.MyAction)
            registerReceiver(mReceiver,this)
        }

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(mReceiver)
    }


}