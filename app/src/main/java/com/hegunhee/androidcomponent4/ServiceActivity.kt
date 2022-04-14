package com.hegunhee.androidcomponent4

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.hegunhee.androidcomponent4.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {
    private lateinit var binding : ActivityServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    var serviceBinder : LocalService.MyBinder? = null
    val connection : ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            (p1 as LocalService.MyBinder)?.run {
                funA(3)
                funB(3)
            }
            Log.d("bindService test","ServiceBinder 받음")
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            serviceBinder = null
            Log.d("bindService test","끝")
        }

    }
    private fun initViews() = with(binding){
        start.setOnClickListener {
            startService()
        }
        end.setOnClickListener {
            endService()
        }
        funA.setOnClickListener {
            serviceBinder?.funA(5)
        }
        funB.setOnClickListener {
            serviceBinder?.funB(5)
        }
    }

    private fun startService(){
        Intent(this,LocalService::class.java)?.run {
            bindService(this,connection,Context.BIND_AUTO_CREATE)
        }
    }

    private fun endService(){
        unbindService(connection)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 10 && resultCode == Activity.RESULT_OK){
            val result = data?.getStringExtra("resultData")
        }
    }

}