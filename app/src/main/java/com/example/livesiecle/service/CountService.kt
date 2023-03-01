package com.example.livesiecle.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Suppress("UNREACHABLE_CODE")
class CountService:Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    Toast.makeText(this,"Service has been started", Toast.LENGTH_SHORT).show()
       startCount()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("check", "Service: onDestroy on stopped")
        Toast.makeText(this,"Service on stopped", Toast.LENGTH_SHORT).show()

    }
    private fun startCount() {
      GlobalScope.launch {
          for (i in 0 until 20){
              Log.d("check", "Service:: Count $i")
              delay(1000)
              if(i == 19)
                  stopSelf()
          }
      }
    }
}