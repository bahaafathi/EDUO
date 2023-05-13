package com.bahaa.eduo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class RectangleActivity : AppCompatActivity() {

    private lateinit var areaEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectangle)

        areaEditText = findViewById(R.id.area_edit_text)
        val previousButton = findViewById<View>(R.id.previous_button)
        val nextButton = findViewById<View>(R.id.next_button)

        previousButton.setOnClickListener {
            finish()
        }

        nextButton.setOnClickListener {
            val areaString = areaEditText.text.toString()
            val area = areaString.toIntOrNull()

            if ((area != null) && (area > 0) && area == calculateRectangleArea()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", "true")
                startActivity(intent)
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", "false")
                startActivity(intent)
            }
        }
    }

    private fun calculateRectangleArea(): Int {
        return 10 * 6
    }
}