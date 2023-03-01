package com.example.livesiecle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.livesiecle.screens.SecondScreen
import com.example.livesiecle.service.ContactsScreen
import com.example.livesiecle.ui.theme.LiveSiecleTheme

class ContactsActivity: ComponentActivity() {

    companion object{
        private const val ARS_SOME_TEXT = "ARG_SOME_TEXT"
        fun newIntent(context: Context, someText: String) =
            Intent(context, ContactsActivity::class.java).apply {
                putExtra(ARS_SOME_TEXT, someText)
            }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val someText = intent?.extras?.getString(ARS_SOME_TEXT)
        Log.d("check", "ContactsActivity on Create $someText")
        setContent {
            LiveSiecleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContactsScreen()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("check", "ContactsActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("check", "ContactsActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("check", "ContactsActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("check", "ContactsActivity: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("check", "ContactsActivity: onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("check", "ContactsActivity: onRestart")
    }
}


