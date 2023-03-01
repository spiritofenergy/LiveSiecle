package com.example.livesiecle

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.livesiecle.receivers.SomeBroadcastReceiver
import com.example.livesiecle.screens.SecondScreen
import com.example.livesiecle.ui.theme.LiveSiecleTheme

class SecondActivity: ComponentActivity() {

    companion object{
        private const val ARS_SOME_TEXT = "ARG_SOME_TEXT"
        fun newIntent(context: Context, someText: String) =
            Intent(context, SecondActivity::class.java).apply {
                putExtra(ARS_SOME_TEXT, someText)
            }
    }
    lateinit var receiver: SomeBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val someText = intent?.extras?.getString(ARS_SOME_TEXT)
        Log.d("check", "SecondActivity on Create $someText")

        receiver = SomeBroadcastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

        setContent {
            LiveSiecleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SecondScreen()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("check", "SecondActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("check", "SecondActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("check", "SecondActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("check", "SecondActivity: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
            unregisterReceiver(receiver)
        Log.d("check", "SecondActivity: onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("check", "SecondActivity: onRestart")
    }
}
