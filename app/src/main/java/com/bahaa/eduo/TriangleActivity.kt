package com.bahaa.eduo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class TriangleActivity : AppCompatActivity() {

    private lateinit var areaEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triangle)

        areaEditText = findViewById(R.id.area_edit_text)
        val previousButton = findViewById<View>(R.id.previous_button)
        val nextButton = findViewById<View>(R.id.next_button)

        previousButton.setOnClickListener {
            finish()
        }

        nextButton.setOnClickListener {
            val areaString = areaEditText.text.toString()
            val area = areaString.toDoubleOrNull()

            if (area != null && area > 0 && isApproximatelyEqual(area, calculateArea())) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", "Good")
                startActivity(intent)
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", "Bad")
                startActivity(intent)
            }
        }
    }

    private fun calculateArea(): Double {
        val b = 8.0
        val h = 4.0
        return b * h / 2.0
    }

    private fun isApproximatelyEqual(a: Double, b: Double): Boolean {
        val epsilon = 0.0001
        return Math.abs(a - b) < epsilon
    }
}
