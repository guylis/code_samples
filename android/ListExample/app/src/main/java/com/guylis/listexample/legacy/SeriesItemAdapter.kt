package com.guylis.listexample.legacy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guylis.listexample.R
import com.guylis.listexample.data.Series

class SeriesItemAdapter(private val list: List<Series>) : RecyclerView.Adapter<SeriesItemAdapter.SeriesDataHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesDataHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.series_item, parent, false)

        return SeriesDataHolder(view)
    }

    override fun onBindViewHolder(holder: SeriesDataHolder, position: Int) {
        val series = list[position]

        holder.imageView.setImageResource(series.imageId)
        holder.titleView.text = series.title
        holder.descriptionView.text = series.description
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SeriesDataHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val titleView: TextView = itemView.findViewById(R.id.title)
        val descriptionView: TextView = itemView.findViewById(R.id.description)
    }

}
