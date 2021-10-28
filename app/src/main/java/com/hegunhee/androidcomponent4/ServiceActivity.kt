package com.hegunhee.androidcomponent4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hegunhee.androidcomponent4.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {
    private lateinit var binding : ActivityServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    private fun initViews() = with(binding){
        start.setOnClickListener {
            startService()
        }
        end.setOnClickListener {
            endService()
        }
    }

    private fun startService(){
        intent = Intent(this,MyService::class.java)
        startService(intent)
    }

    private fun endService(){
        intent = Intent(this,MyService::class.java)
        stopService(intent)
    }

}