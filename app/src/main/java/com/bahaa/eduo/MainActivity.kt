package com.bahaa.eduo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var triangleButton: Button
    private lateinit var circleButton: Button
    private lateinit var rectangleButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        triangleButton = findViewById(R.id.triangle_button)
        circleButton = findViewById(R.id.circle_button)
        rectangleButton = findViewById(R.id.rectangle_button)

        triangleButton.setOnClickListener {
            if (!isValidImageName("triangle")) {
                showErrorMessage("Incorrect image name!")
                return@setOnClickListener
            }
            val intent = Intent(this, TriangleActivity::class.java)
            startActivity(intent)
        }
        circleButton.setOnClickListener {
            if (!isValidImageName("circle")) {
                showErrorMessage("Incorrect image name!")
                return@setOnClickListener
            }
            val intent = Intent(this, CircleActivity::class.java)
            startActivity(intent)
        }
        rectangleButton.setOnClickListener {
            if (!isValidImageName("rectangle")) {
                showErrorMessage("Incorrect image name!")
                return@setOnClickListener
            }
            val intent = Intent(this, RectangleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidImageName(imageName: String): Boolean {
        val editText = getEditText(imageName)
        return editText.text.toString().equals(imageName, ignoreCase = true);
    }

    private fun getEditText(imageName: String): EditText {
        return when (imageName) {
            "triangle" -> findViewById(R.id.triangle_edit_text)
            "circle" -> findViewById(R.id.circle_edit_text)
            "rectangle" -> findViewById(R.id.rectangle_edit_text)
            else -> throw IllegalArgumentException("Invalid image name: $imageName")
        }
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
}
