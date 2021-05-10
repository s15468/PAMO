package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.QuizActivity
import java.util.*

class QuizActivity : AppCompatActivity() {
    var answer1: Button? = null
    var answer2: Button? = null
    var answer3: Button? = null
    var answer4: Button? = null
    var question: TextView? = null
    var score: TextView? = null
    var questions = Quiz()
    var correctAnswer: String? = null
    var actualScore = 0
    var questionsLenght = questions.Questions.size
    var r: Random? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        r = Random()
        question = findViewById<View>(R.id.questionTextView) as TextView
        score = findViewById<View>(R.id.scoreTextView) as TextView
        answer1 = findViewById<View>(R.id.answer1Button) as Button
        answer2 = findViewById<View>(R.id.answer2Button) as Button
        answer3 = findViewById<View>(R.id.answer3Button) as Button
        answer4 = findViewById<View>(R.id.answer4Button) as Button
        updateQuestion(r!!.nextInt(questionsLenght))
        answer1!!.setOnClickListener {
            if (answer1!!.text === correctAnswer) {
                actualScore++
                score!!.text = "" + score
                updateQuestion(r!!.nextInt(questionsLenght))
            } else {
                gameOver()
            }
        }
        answer2!!.setOnClickListener {
            if (answer2!!.text === correctAnswer) {
                actualScore++
                score!!.text = "" + score
                updateQuestion(r!!.nextInt(questionsLenght))
            } else {
                gameOver()
            }
        }
        answer3!!.setOnClickListener {
            if (answer3!!.text === correctAnswer) {
                actualScore++
                score!!.text = "" + score
                updateQuestion(r!!.nextInt(questionsLenght))
            } else {
                gameOver()
            }
        }
        answer4!!.setOnClickListener {
            if (answer4!!.text === correctAnswer) {
                actualScore++
                score!!.text = "" + score
                updateQuestion(r!!.nextInt(questionsLenght))
            } else {
                gameOver()
            }
        }
    }

    private fun updateQuestion(num: Int) {
        question!!.text = questions.getQuestion(num)
        answer1!!.text = questions.getChoice1(num)
        answer2!!.text = questions.getChoice2(num)
        answer3!!.text = questions.getChoice3(num)
        answer4!!.text = questions.getChoice4(num)
        correctAnswer = questions.getCorrectAnswer(num)
    }

    private fun gameOver() {
        val alertDialogBuilder = AlertDialog.Builder(this@QuizActivity)
        alertDialogBuilder
                .setMessage("Koniec gry! Twój wynik to $actualScore")
                .setCancelable(false)
                .setPositiveButton("Nowa gra"
                ) { dialog, which -> startActivity(Intent(applicationContext, QuizActivity::class.java)) }
                .setNegativeButton("Wyjście"
                ) { dialog, which -> startActivity(Intent(applicationContext, MainActivity::class.java)) }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}