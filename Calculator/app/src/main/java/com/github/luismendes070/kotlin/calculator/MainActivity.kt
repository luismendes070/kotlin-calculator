package com.github.luismendes070.kotlin.calculator

// import androidx.appcompat.app.AppCompatActivity
// import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.github.luismendes070.kotlin.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var resultTextView: TextView
    private var currentNumber = StringBuilder()
    private var currentOperator = ""
    private var operand1 = 0.0
    private var operand2 = 0.0

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        val buttons = listOf(
            findViewById<Button>(R.id.buttonOne),
            // Include references to all the other buttons in a similar way
        )

        for (button in buttons) {
            button.setOnClickListener(this)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }
    } // end method onCreate

    override fun onClick(view: View?) {
        if (view is Button) {
            val value = view.text.toString()
            when (value) {
                in listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9") -> {
                    currentNumber.append(value)
                    resultTextView.text = currentNumber.toString()
                }
                "." -> {
                    if (!currentNumber.contains(".")) {
                        currentNumber.append(value)
                        resultTextView.text = currentNumber.toString()
                    }
                }
                "+" -> {
                    performOperation(value)
                }
                "-" -> {
                    performOperation(value)
                }
                "*" -> {
                    performOperation(value)
                }
                "/" -> {
                    performOperation(value)
                }
                "=" -> {
                    performEquals()
                }
                "C" -> {
                    clearCalculator()
                }
            }
        }
    }

    private fun performOperation(operator: String) {
        operand1 = currentNumber.toString().toDouble()
        currentNumber.clear()
        currentOperator = operator
    }

    private fun performEquals() {
        if (currentNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
            operand2 = currentNumber.toString().toDouble()
            currentNumber.clear()
            when (currentOperator) {
                "+" -> currentNumber.append(operand1 + operand2)
                "-" -> currentNumber.append(operand1 - operand2)
                "*" -> currentNumber.append(operand1 * operand2)
                "/" -> {
                    if (operand2 != 0.0) {
                        currentNumber.append(operand1 / operand2)
                    } else {
                        currentNumber.append("Error")
                    }
                }
            }
            resultTextView.text = currentNumber.toString()
            currentOperator = ""
        }
    }

    private fun clearCalculator() {
        currentNumber.clear()
        resultTextView.text = "0"
        currentOperator = ""
        operand1 = 0.0
        operand2 = 0.0
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}