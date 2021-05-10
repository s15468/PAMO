package com.example.bmicalculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    private var yourScore: TextView? = null
    private var yourBMR: TextView? = null
    private var openRecipeButton: Button? = null
    private var url: String? = null
    private var weight: Float? = null
    private var height: Float? = null
    private var sex: String? = null
    private var age: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        openRecipeButton = findViewById<View>(R.id.openRecipe) as Button
        yourScore = findViewById<View>(R.id.scoreText) as TextView
        yourBMR = findViewById<View>(R.id.bmrText) as TextView
        val extras = intent.extras
        if (extras != null) {
            weight = extras.getString("weight").toFloat()
            height = extras.getString("height").toFloat()
            age = extras.getString("age").toInt()
            sex = extras.getString("sex")
        }
        displayBMI(calculateBMI())
        displayBMR(calculateBMR())
        openRecipeButton = findViewById<View>(R.id.openRecipe) as Button
        openRecipeButton!!.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }
    }

    private fun calculateBMR(): Float {
        return if (sex === "Male") {
            66.5f + 13.75f * weight!! + 5.003f * height!! - 6.775f * age as Float
        } else {
            655.1f + 9.563f * weight!! + 1.85f * height!! - 4.676f * age as Float
        }
    }

    private fun calculateBMI(): Float {
        return weight!! / (height!! / 100 * (height!! / 100))
    }

    private fun displayBMI(bmi: Float) {
        var bmiLabel = ""
        bmiLabel = if (java.lang.Float.compare(bmi, 15f) <= 0) "Very severely underweight" else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 16f) <= 0) "Severely underweight" else if (java.lang.Float.compare(bmi, 16f) > 0 && java.lang.Float.compare(bmi, 18.5f) <= 0) "Underweight" else if (java.lang.Float.compare(bmi, 18.5f) > 0 && java.lang.Float.compare(bmi, 25f) <= 0) "Normal" else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(bmi, 30f) <= 0) "Overweight" else if (java.lang.Float.compare(bmi, 30f) > 0 && java.lang.Float.compare(bmi, 35f) <= 0) "Obese Class I" else if (java.lang.Float.compare(bmi, 35f) > 0 && java.lang.Float.compare(bmi, 40f) <= 0) "Obese Class II" else "Obese Class III"
        if (bmi < 18.5f) url = "https://www.100daysofrealfood.com/loaded-black-bean-burgers/" else if (bmi >= 18.5f && bmi <= 25f) url = "https://www.100daysofrealfood.com/chicken-pesto-pizza/" else if (bmi > 25f) url = "https://www.100daysofrealfood.com/green-smoothie-recipe/"
        yourScore!!.text = bmiLabel
    }

    private fun displayBMR(bmr: Float) {
        yourBMR!!.text = java.lang.Float.toString(bmr)
    }
}