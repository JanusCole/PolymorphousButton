package com.januscole.polymorphousbutton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun redButtonClick(v : View) {Toast.makeText(this, "Red Button Clicked", Toast.LENGTH_SHORT).show()}
    fun blueButtonClick(v : View) {Toast.makeText(this, "Blue Button Clicked", Toast.LENGTH_SHORT).show()}

}
