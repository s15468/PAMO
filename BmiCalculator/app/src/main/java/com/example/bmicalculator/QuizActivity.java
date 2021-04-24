package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class QuizActivity extends AppCompatActivity
{
    Button answer1, answer2, answer3, answer4;
    TextView question;
    TextView score;

    Quiz questions = new Quiz();

    String correctAnswer;
    int actualScore = 0;
    int questionsLenght = questions.Questions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        r = new Random();

        question = (TextView) findViewById(R.id.questionTextView);
        score = (TextView) findViewById(R.id.scoreTextView);
        answer1 = (Button) findViewById(R.id.answer1Button);
        answer2 = (Button) findViewById(R.id.answer2Button);
        answer3 = (Button) findViewById(R.id.answer3Button);
        answer4 = (Button) findViewById(R.id.answer4Button);

        updateQuestion(r.nextInt(questionsLenght));

        answer1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (answer1.getText() == correctAnswer)
                {
                    actualScore++;
                    score.setText(""+ score);
                    updateQuestion(r.nextInt(questionsLenght));
                }
                else
                {
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (answer2.getText() == correctAnswer)
                {
                    actualScore++;
                    score.setText(""+ score);
                    updateQuestion(r.nextInt(questionsLenght));
                }
                else
                {
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (answer3.getText() == correctAnswer)
                {
                    actualScore++;
                    score.setText(""+ score);
                    updateQuestion(r.nextInt(questionsLenght));
                }
                else
                {
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (answer4.getText() == correctAnswer)
                {
                    actualScore++;
                    score.setText(""+ score);
                    updateQuestion(r.nextInt(questionsLenght));
                }
                else
                {
                    gameOver();
                }
            }
        });
    }

    private void updateQuestion(int num)
    {
        question.setText(questions.getQuestion(num));
        answer1.setText(questions.getChoice1(num));
        answer2.setText(questions.getChoice2(num));
        answer3.setText(questions.getChoice3(num));
        answer4.setText(questions.getChoice4(num));

        correctAnswer = questions.getCorrectAnswer(num);
    }

    private void gameOver()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizActivity.this);
        alertDialogBuilder
                .setMessage(("Koniec gry! Twój wynik to " + actualScore))
                .setCancelable(false)
                .setPositiveButton("Nowa gra",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
                            }
                        })
                .setNegativeButton("Wyjście",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
