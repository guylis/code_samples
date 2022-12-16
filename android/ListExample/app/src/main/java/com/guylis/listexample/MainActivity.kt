package com.guylis.listexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guylis.listexample.compose.ComposeListActivity
import com.guylis.listexample.legacy.LegacyListActivity
import com.guylis.listexample.ui.theme.ListExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListExampleTheme {
                InitialScreen()
            }
        }
    }
}

@Composable
fun InitialScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center


    ) {
        val context = LocalContext.current
        ButtonList(
            text = "show list with compose" ,
            buttonClick = {  context.startActivity(Intent(context, ComposeListActivity::class.java)) })
        ButtonList(
            text = "show list with xml" ,
            buttonClick = {  context.startActivity(Intent(context, LegacyListActivity::class.java)) })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ListExampleTheme {
        InitialScreen()
    }
}

@Composable
fun ButtonList(text : String, buttonClick : () -> Unit) {
    Button(
        modifier = Modifier.width(250.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
        onClick = buttonClick) {
        Text(color = Color.White, text = text)
    }
}