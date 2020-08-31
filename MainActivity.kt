package com.example.sample

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_category_title.view.*

class MainActivity : AppCompatActivity(), MyClickListener.OnRecyclerClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = MyAdapter()


        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        recyclerView.addOnItemTouchListener(MyClickListener(this, recyclerView, this))
    }

    override fun onItemClick(view: View, position: Int) {
        "アイテムがシングルクリックされました。".easyLog()
    }


    override fun onItemLongClick(view: View, position: Int) {
        val dialog = MyDialog()
        dialog.show(supportFragmentManager, "HASEGAWA")
    }
}
