package com.example.movielist


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var myAdapter: MyAdapterView
    private lateinit var recyclerViewNew: RecyclerView
    private lateinit var myDataList: MutableList<MyData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewNew = findViewById(R.id.recycleView)
        initRecyclerView()
        // showCustomToast()
    }

    private fun initRecyclerView() {
        myDataList = ArrayList()
        myDataList.add(MyData(R.drawable.dracula, "Dracula", false))
        myDataList.add(MyData(R.drawable.ghostbusters, "Ghost Busters", false))
        myDataList.add(MyData(R.drawable.venom, "Venom", false))
        myAdapter = MyAdapterView(this, myDataList,
            { position ->
                val myDataAtPosition = myDataList[position]
                if (myDataAtPosition.isBookmarked) {
                    myDataAtPosition.isBookmarked = false
                } else {
                    myDataAtPosition.isBookmarked = true
                }
                myAdapter.notifyItemChanged(position)

            })
        recyclerViewNew.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewNew.adapter = myAdapter


//        Handler().postDelayed({
//            myDataList.add(MyData(R.drawable.ic_launcher_background, "Background",false))
//            myAdapter.notifyItemRangeInserted(4, 2)
//        }, 1000)
    }

}