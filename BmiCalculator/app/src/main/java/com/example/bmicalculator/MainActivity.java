package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button startButton;
    private Button quizButton;
    private Button covidInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        covidInfoButton = (Button) findViewById(R.id.covidInfoButton);
        quizButton = (Button) findViewById(R.id.quizButton);
        startButton = (Button) findViewById(R.id.StartButton);

        covidInfoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) { covidInfoActivity(); }
        });

        quizButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View v) { quizActivity(); }
        }));

        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                calculatorActivity();
            }
        });
    }

    public void quizActivity()
    {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void covidInfoActivity()
    {
        Intent intent = new Intent(this, CovidInfoActivity.class);
        startActivity(intent);
    }

    public void calculatorActivity()
    {
        Intent intent = new Intent(this,CalculatorActivity.class);
        startActivity(intent);
    }
}