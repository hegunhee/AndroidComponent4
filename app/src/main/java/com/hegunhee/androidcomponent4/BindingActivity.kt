package com.hegunhee.androidcomponent4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hegunhee.androidcomponent4.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBindingBinding
    private lateinit var mService : LocalService
    private var mBound : Boolean = false

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            val binder = service as LocalService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        button.setOnClickListener{
            if(mBound){
                val num = mServer.randomNumber
                android.widget.Toast.makeText(this, "number : $num", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this,LocalService::class.java).also{intent->
            bindService(intent,connection,Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        mBound = false
    }
}