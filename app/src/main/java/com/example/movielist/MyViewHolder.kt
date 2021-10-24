package com.example.movielist

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(
    private val itemView: View,
    private val onBookmarkedClicked:(position: Int)-> Unit) : RecyclerView.ViewHolder(itemView) {
    val myImageView: ImageView = itemView.findViewById(R.id.movie_image)
    val textViewTitle: TextView = itemView.findViewById(R.id.movie_title)
    val imageButtonBookmark: ImageButton = itemView.findViewById(R.id.imageButtonBookmark)


    init {
        imageButtonBookmark.setOnClickListener{
            onBookmarkedClicked(adapterPosition)
        }
    }
}