package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    private var height: EditText? = null
    private var weight: EditText? = null
    private var age: EditText? = null
    private var radioGroup: RadioGroup? = null
    private var calculateButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        height = findViewById<View>(R.id.enterHeightNumber) as EditText
        weight = findViewById<View>(R.id.enterWeightNumber) as EditText
        age = findViewById<View>(R.id.enterAgeNumber) as EditText
        radioGroup = findViewById<View>(R.id.radioGroup) as RadioGroup
        calculateButton = findViewById<View>(R.id.CalculateButton) as Button
        calculateButton!!.setOnClickListener { scoreActivity() }
    }

    fun scoreActivity() {
        if (height!!.text.toString() === "" || weight!!.text.toString() === "" || age!!.text.toString() === "") return
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("height", height!!.text.toString())
        intent.putExtra("weight", weight!!.text.toString())
        intent.putExtra("age", age!!.text.toString())
        val selectedRadioId = radioGroup!!.checkedRadioButtonId
        val selectedRadioButton = findViewById<View>(selectedRadioId) as RadioButton
        intent.putExtra("sex", selectedRadioButton.text)
        startActivity(intent)
    }
}