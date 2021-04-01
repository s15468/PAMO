package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity
{
    private EditText height;
    private EditText weight;
    private Float score;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        height = (EditText) findViewById(R.id.enterHeightNumber);
        weight = (EditText) findViewById(R.id.enterWeightNumber);

        calculateButton = (Button) findViewById(R.id.CalculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                scoreActivity();
            }
        });
    }

    public void scoreActivity()
    {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && heightStr != "" && weightStr != null && weightStr != "") {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            score = weightValue / (heightValue * heightValue);
        }

        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }
}