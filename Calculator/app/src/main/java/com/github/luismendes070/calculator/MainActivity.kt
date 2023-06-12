package com.github.luismendes070.calculator

// import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
// import androidx.appcompat.app.AppCompatActivity

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
import com.github.luismendes070.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var operand1EditText: EditText
    private lateinit var operand2EditText: EditText

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        operand1EditText = findViewById(R.id.operand1)
        operand2EditText = findViewById(R.id.operand2)

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

        operand1EditText.addTextChangedListener(textWatcher)
        operand2EditText.addTextChangedListener(textWatcher)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->

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

        }

    }

    private fun performCalculation() {
        val operand1 = operand1EditText.text.toString().toDoubleOrNull()
        val operand2 = operand2EditText.text.toString().toDoubleOrNull()

        if (operand1 != null && operand2 != null) {
            val result = operand1 + operand2 // Perform your desired calculation here
            // Display the result in a TextView or any other way you prefer
        }
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