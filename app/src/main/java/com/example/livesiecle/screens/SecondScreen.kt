package com.example.livesiecle.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.livesiecle.ContactsActivity
import com.example.livesiecle.service.ContactsScreen
import com.example.livesiecle.service.CountService

@SuppressLint("SuspiciousIndentation")
@Composable
fun SecondScreen() {
    val context = LocalContext.current
    val activity = if (context is Activity)context else null
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Second Activity Screen ")
        Button(onClick = {
           activity?.finish()
        }) {
            Text("Go to First Activity")
        }
        Row(
            modifier = Modifier.padding(top = 20.dp)
        )
        {
            Button(onClick = {
            activity?.startService(Intent(context, CountService::class.java))
            }) { Text(text = "start service") }
        }
        Row(modifier = Modifier.padding(top = 20.dp)) {
            Button(onClick = {
                activity?.stopService(Intent(context, CountService::class.java))
            }) { Text(text = "stop service") }
        }
        Row(modifier = Modifier.padding(top = 20.dp)) {
            Button(onClick = {
                val intent1 = ContactsActivity.newIntent(context = context, "")
                    context.startActivity(intent1)
            }) { Text(text = "ContactsActivity") }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun FirstScreenPreview(){
    SecondScreen()
}