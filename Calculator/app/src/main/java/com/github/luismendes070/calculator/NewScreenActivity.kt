package com.github.luismendes070.calculator;

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity

class NewScreenActivity : AppCompatActivity() {
    // Define your activity logic and UI here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_screen)

        // Example: Handle a button click to return a result
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        buttonSubmit.setOnClickListener {
            val resultIntent = Intent().apply {
                // Set any data you want to pass back as a result
                putExtra("key", "value")
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

}

