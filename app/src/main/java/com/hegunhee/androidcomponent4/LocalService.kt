package com.hegunhee.androidcomponent4

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*

class LocalService : Service() {
    override fun onCreate() {
        super.onCreate()
        Log.d("bindService Test","bind test")

    }
    class MyBinder : Binder(){
        fun funA(a : Int){
            Log.d("bindService Test" ,"$a")
        }
        fun funB(a: Int) : Int{
            Log.d("bindService Test","${a*a}")
            return a*a
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return MyBinder()
    }
}