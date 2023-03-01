package com.example.livesiecle.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SomeBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneMode = intent?.getBooleanExtra("state", false) ?: false
    if (isAirplaneMode){
        Log.d("check", "Airplane mode enabled")
    }else{
        Log.d("check", "Airplane mode disabled")
         }
    }
}