package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CalculatorActivity extends AppCompatActivity
{
    private EditText height;
    private EditText weight;
    private EditText age;
    private RadioGroup radioGroup;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        height = (EditText) findViewById(R.id.enterHeightNumber);
        weight = (EditText) findViewById(R.id.enterWeightNumber);
        age = (EditText) findViewById(R.id.enterAgeNumber);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


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
        if (height.getText().toString() == "" || weight.getText().toString() == "" || age.getText().toString() == "")
            return;

        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("height", height.getText().toString());
        intent.putExtra("weight", weight.getText().toString());
        intent.putExtra("age", age.getText().toString());

        int selectedRadioId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioId);

        intent.putExtra("sex", selectedRadioButton.getText());
        startActivity(intent);
    }
}