package com.github.luismendes070.kotlin.calculator

// import androidx.appcompat.app.AppCompatActivity
// import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.widget.EditText
import com.github.luismendes070.kotlin.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var currentNumber: String

    private var currentOperator = ""
    private lateinit var operand1 : EditText
    private lateinit var operand2 : EditText

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {

        try{
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            operand1 = findViewById(R.id.textview_first)
            operand2 = findViewById(R.id.textview_valueB)

            // Add a TextWatcher to monitor changes in the operands' EditText fields
            val textWatcher = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    performCalculation()
                }
            }

            operand1.addTextChangedListener(textWatcher)
            operand2.addTextChangedListener(textWatcher)
        }catch(e:Exception){

        }finally{

        }


    } // end method onCreate


    private fun performCalculation() {
        val operand1 = operand1.text.toString().toDoubleOrNull()
        val operand2 = operand2.text.toString().toDoubleOrNull()

        if (operand1 != null && operand2 != null) {
            val result = operand1 + operand2 // Perform your desired calculation here
            // Display the result in a TextView or any other way you prefer
        }
    }













}