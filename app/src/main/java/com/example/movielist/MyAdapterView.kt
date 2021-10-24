package com.example.movielist

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

class MyAdapterView(
    private val context: Context,
    private val myDataList: MutableList<MyData>,
    private val onBookmarkedClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(parent.inflate(R.layout.activity_my_adapter_view),
            {position -> onBookmarkedClicked(position)} )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myData = myDataList[position]
        Log.d("BindViewHolderCalled", "position -> $position")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.myImageView.setImageDrawable(context.getDrawable(myData.drawable))
        }
        holder.textViewTitle.text = myData.title


        if (myData.isBookmarked) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.imageButtonBookmark.imageTintList = ColorStateList.valueOf(Color.GREEN)
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.imageButtonBookmark.imageTintList = ColorStateList.valueOf(Color.GRAY)
            }
        }
    }


    override fun getItemCount() = myDataList.count()

}
