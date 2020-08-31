package com.example.sample

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.RecyclerView


class MyClickListener(
    context: Context, recyclerView: RecyclerView, private val listener: MyClickListener.OnRecyclerClickListener
): RecyclerView.SimpleOnItemTouchListener(

) {

    private val gestureDetector = GestureDetectorCompat(context, object: GestureDetector.SimpleOnGestureListener() {

        override fun onLongPress(e: MotionEvent?) {
            val childView = if (e != null) {
                recyclerView.findChildViewUnder(e.x, e.y)
            } else {
                return
            }

            if (childView != null) {
                listener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView))
            }
        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            val childView = recyclerView.findChildViewUnder(e?.x!!, e?.y!!)

            if (childView != null) {
                listener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView))
            }
            return true
        }
    })

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(e)
    }

    interface OnRecyclerClickListener{
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }


}