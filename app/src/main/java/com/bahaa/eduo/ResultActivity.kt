package com.bahaa.eduo

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView = findViewById<TextView>(R.id.result_text_view)
        val resultImageView = findViewById<ImageView>(R.id.result_image_view)
        val previousButton = findViewById<View>(R.id.previous_button)

        val result = intent.getStringExtra("result").toBoolean()


        if (result) {
            resultImageView.setImageResource(R.drawable.smiley)
            resultTextView.text = "Right"
        } else {
            resultImageView.setImageResource(R.drawable.sad)
            resultTextView.text = "Wrong"
        }



        previousButton.setOnClickListener {
            finish()
        }

    }
}

