package com.januscole.polymorphousbutton

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.support.v7.widget.AppCompatImageButton
import android.view.MotionEvent

class PolymorphousButton : AppCompatImageButton {
    constructor(context: Context) : super(context) {
        // You need to set DrawingCacheEnabled to true
        isDrawingCacheEnabled = true
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        // You need to set DrawingCacheEnabled to true
        isDrawingCacheEnabled = true
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        // You need to set DrawingCacheEnabled to true
        isDrawingCacheEnabled = true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        // Process ACTION_UP and ACTION_DOWN events

        when (event.action) {

            MotionEvent.ACTION_DOWN -> {

                // For the ACTION_DOWN event, we want to check the color at the touch location
                val touchLocationColor: Int

                // Get the location of the touch event and cast to an Int
                val xTouchLocation = event.x.toInt()
                val yTouchLocation = event.y.toInt()

                try {

                    // Get the pixel at the touch location, which means getting the
                    // pixel color.

                    touchLocationColor = drawingCache.getPixel(xTouchLocation, yTouchLocation)

                } catch (e: IllegalArgumentException) {

                    // The IllegalArgumentException error will get thrown only if the
                    // location of the touch event was outside the bounds of the view.
                    // And in that case, it obviously should be bypassed.

                    return false
                }

                // Return true and accept the touch event if the color of the pixel at the
                // touch location was TRANSPARENT. Otherwise, don't process the event.

                return touchLocationColor != Color.TRANSPARENT
            }


            MotionEvent.ACTION_UP -> {

                // Presumably, by this point, you have determined that the touch event was
                // inside the view bounds and not TRANSPARENT. So you can process the click.

                performClick()

                return true
            }
        }

        return false // Return false for other touch events

    }

    // Depending on your Lint configuration, Android may show an error telling
    // you that you need to override the performClick method. This is for
    // accessibility. Google wants you to provide an implementation for users who
    // don't use the touch screen. But in this case, since the override is specific
    // to the touch screen, you can override it with a no-op implementation.

}
