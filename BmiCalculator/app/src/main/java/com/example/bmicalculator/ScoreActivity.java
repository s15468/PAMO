package com.example.bmicalculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity
{
    private TextView yourScore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        yourScore = (TextView) findViewById(R.id.scoreText);
        Bundle extras = getIntent().getExtras();

        Float score = 0f;
        if (extras != null)
        {
            score = extras.getFloat("score");
        }


        displayBMI(score);
    }

    private void displayBMI(float bmi)
    {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0)
            bmiLabel = "Very severely underweight";
        else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0)
            bmiLabel = "Severely underweight";
        else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0)
            bmiLabel = "Underweight";
        else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0)
            bmiLabel = "Normal";
        else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0)
            bmiLabel= "Overweight";
        else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0)
            bmiLabel = "Obese Class I";
        else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0)
            bmiLabel = "Obese Class II";
        else
            bmiLabel = "Obese Class III";

        yourScore.setText(bmiLabel);
    }
}