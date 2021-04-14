package com.amirhusseinsoori.swipegesture

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.TextView

class SwipeListener constructor(view: View,var textView: TextView,context: Context) : View.OnTouchListener {



    lateinit var gestureDetector: GestureDetector


    init {
        var threshold: Int = 100
        var velocity_threshold = 100


        var listener = object : GestureDetector.SimpleOnGestureListener() {

            override fun onDown(e: MotionEvent?): Boolean {
                return true
            }

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent?,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                //GET x and y different
                var xDiff = e2!!.x - e1!!.x
                var yDiff = e2.y - e1.y

                try{
                    if(Math.abs(xDiff) > Math.abs(yDiff)){
                        //when x is greater than y
                        //check condition
                        if(Math.abs(xDiff) > threshold && Math.abs(velocityX) > velocity_threshold){
                            //when x different is greater than threshold
                            //when  x velocity  is greater than velocity threshold
                            if(xDiff > 0){
                                textView.text="Swiped Right"
                            }else{
                                textView.text="Swiped Left"
                            }
                            return true
                        }
                    }else{
                        //when y is greater than  x
                        if(Math.abs(yDiff) > threshold && Math.abs(velocityY) > velocity_threshold){
                            //when y different is greater than threshold
                            //when  y velocity  is greater than velocity threshold
                            if(yDiff > 0){
                                textView.text="Swiped Down"
                            }else{
                                textView.text="Swiped Up"
                            }
                            return true
                        }
                    }

                }catch (ex:Exception){
                    ex.printStackTrace()
                }
                return false
            }


        }
        gestureDetector=GestureDetector(context,listener,null)
        view.setOnTouchListener(this)


    }


    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
      return gestureDetector.onTouchEvent(event!!)
    }
}