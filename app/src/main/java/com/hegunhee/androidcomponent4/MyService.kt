package com.hegunhee.androidcomponent4

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MyService : Service(),CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job
    private val job = Job()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("Service", "StartService")
        launch(coroutineContext) {
            for (i in 0 until 100) {
                Log.d("MyService", "Service $i")
                delay(100)
            }
            stopSelf()
        }

        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        Log.d("Service", "StopService")

    }

}