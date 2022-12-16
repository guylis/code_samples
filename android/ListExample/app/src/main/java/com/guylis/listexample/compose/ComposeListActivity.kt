package com.guylis.listexample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guylis.listexample.ui.theme.ListExampleTheme
import com.guylis.listexample.data.Series
import com.guylis.listexample.data.SeriesDataProvider

class ComposeListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListExampleTheme {
                SeriesList()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        SeriesList()
    }

    @Composable
    fun SeriesList() {
        LazyColumn(
            modifier = Modifier.background(Color.Black)
        ) {
            items(
                items = SeriesDataProvider.seriesList,
                itemContent = {
                    Series(series = it)
                }
            )
        }
    }


    @Composable
    fun Series(series : Series) {
        Row() {
            Image(
                modifier =  Modifier.size(150.dp).align(Alignment.CenterVertically),
                painter =  painterResource(id = series.imageId),
                contentDescription = "")
            Column(
                modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically)
            ) {
                Text(color = Color.White, text = series.title, style = typography.h6)
                Text(color = Color.White,text = series.description, style = typography.caption)
            }
        }

    }





}