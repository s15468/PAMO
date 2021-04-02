package com.example.bmicalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity
{
    private TextView yourScore;
    private TextView yourBMR;
    private Button openRecipeButton;
    private String url;
    private Float weight;
    private Float height;
    private String sex;
    private Integer age;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        openRecipeButton = (Button) findViewById(R.id.openRecipe);
        yourScore = (TextView) findViewById(R.id.scoreText);
        yourBMR = (TextView) findViewById(R.id.bmrText);
        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {
            weight = Float.parseFloat(extras.getString("weight"));
            height = Float.parseFloat(extras.getString("height"));
            age = Integer.parseInt(extras.getString("age"));
            sex = extras.getString("sex");
        }

        displayBMI(calculateBMI());
        displayBMR(calculateBMR());

        openRecipeButton = (Button) findViewById(R.id.openRecipe);
        openRecipeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
    }

    private float calculateBMR()
    {
        if (sex == "Male")
        {
            return 66.5f + (13.75f * weight) + (5.003f * height) - (6.775f * (float)age);
        }
        else
        {
            return 655.1f + (9.563f * weight) + (1.85f * height ) - (4.676f * (float) age);
        }
    }

    private float calculateBMI()
    {
        return weight / ((height / 100) * (height / 100));
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

        if (bmi < 18.5f)
            url = "https://www.100daysofrealfood.com/loaded-black-bean-burgers/";
        else if (bmi >= 18.5f && bmi <= 25f)
            url = "https://www.100daysofrealfood.com/chicken-pesto-pizza/";
        else if (bmi > 25f)
            url = "https://www.100daysofrealfood.com/green-smoothie-recipe/";

        yourScore.setText(bmiLabel);
    }

    private void displayBMR(float bmr)
    {
        yourBMR.setText(Float.toString(bmr));
    }
}