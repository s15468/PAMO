package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var startButton: Button? = null
    private var quizButton: Button? = null
    private var covidInfoButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        covidInfoButton = findViewById<View>(R.id.covidInfoButton) as Button
        quizButton = findViewById<View>(R.id.quizButton) as Button
        startButton = findViewById<View>(R.id.StartButton) as Button
        covidInfoButton!!.setOnClickListener { covidInfoActivity() }
        quizButton!!.setOnClickListener { quizActivity() }
        startButton!!.setOnClickListener { calculatorActivity() }
    }

    fun quizActivity() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    fun covidInfoActivity() {
        val intent = Intent(this, CovidInfoActivity::class.java)
        startActivity(intent)
    }

    fun calculatorActivity() {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }
}