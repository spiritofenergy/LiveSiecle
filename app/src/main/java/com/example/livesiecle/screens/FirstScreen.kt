package com.example.livesiecle

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun FirstScreen() {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "First Activity Screen ")
        Button(
            onClick = {
           // val intent1 = Intent(context, SecondActivity::class.java)
                val intent1 = SecondActivity.newIntent(context = context, "Some Text text")
            context.startActivity(intent1)
        }) {

            Text("Go to Second Activity")
        }
        Button(
            onClick = {
                 val intent2 = ContactsActivity.newIntent(context = context, "Some Text text")
            context.startActivity(intent2)
        }) {

            Text("Go to Contact Activity")
        }
        
    }

}
@Preview(showBackground = true)
@Composable
 fun FirstScreenPreview(){
     FirstScreen()
 }