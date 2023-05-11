package com.bahaa.eduo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val triangleButton = findViewById<View>(R.id.triangle_button)
        val circleButton = findViewById<View>(R.id.circle_button)
        val rectangleButton = findViewById<View>(R.id.rectangle_button)

        triangleButton.setOnClickListener {
            val intent = Intent(this, TriangleActivity::class.java)
            startActivity(intent)
        }

        circleButton.setOnClickListener {
            val intent = Intent(this, CircleActivity::class.java)
            startActivity(intent)
        }

        rectangleButton.setOnClickListener {
            val intent = Intent(this, RectangleActivity::class.java)
            startActivity(intent)
        }
    }
}
