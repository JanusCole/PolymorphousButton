package com.januscole.polymorphousbutton

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.support.v7.widget.AppCompatImageButton
import android.view.MotionEvent

class PolymorphousButton : AppCompatImageButton {
    constructor(context: Context) : super(context) {
        isDrawingCacheEnabled = true
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        isDrawingCacheEnabled = true
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        isDrawingCacheEnabled = true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        // Listening for the down and up touch events

        when (event.action) {

            MotionEvent.ACTION_DOWN -> {

                val touchLocationColor: Int

                try {

                    touchLocationColor = drawingCache.getPixel(event.x.toInt(), event.y.toInt())

                } catch (e: IllegalArgumentException) {

                    // This will occur if the x and y values are outside the bounds of the

                    // view. In that case, the touch event was definitely outside the image

                    // area and should not be processed

                    return false

                }

                return touchLocationColor != Color.TRANSPARENT
            }


            MotionEvent.ACTION_UP -> {

                performClick()

                return true
            }
        }

        return false // Return false for other touch events

    }


    /*  Android requires that the performClick method be overridden when onTouchEvent

    is overridden. This is for AccessibilityEvents. However, in this case,

    performClick requires no changes.

*/

    override fun performClick(): Boolean {

        // Calls the super implementation, which generates an AccessibilityEvent

        // and calls the onClick() listener on the view, if any

        return super.performClick()

    }

}
