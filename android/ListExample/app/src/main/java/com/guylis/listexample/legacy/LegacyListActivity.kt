package com.guylis.listexample.legacy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guylis.listexample.R
import com.guylis.listexample.data.SeriesDataProvider

class LegacyListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.series_list)

        val seriesList = findViewById<RecyclerView>(R.id.recyclerview)
        seriesList.layoutManager = LinearLayoutManager(this)
        val adapter = SeriesItemAdapter(SeriesDataProvider.seriesList)
        seriesList.adapter = adapter

    }

}