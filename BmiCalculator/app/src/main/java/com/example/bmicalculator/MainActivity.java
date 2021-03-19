package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.editHeightText);
        weight = (EditText) findViewById(R.id.editWeightText);
        result = (TextView) findViewById(R.id.currentBMI);
    }

    public void CalculateBMI(View v)
    {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && heightStr != "" &&  weightStr != null && weightStr != "")
        {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
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

        result.setText(bmiLabel);
    }
}