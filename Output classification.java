package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etWeight, etHeight;
    Button btnCalculate;
    TextView tvBMIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvBMIResult = findViewById(R.id.tvBMIResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                
                double weight = Double.parseDouble(etWeight.getText().toString());
                double height = Double.parseDouble(etHeight.getText().toString());

                
                double bmi = weight / (height * height);

                
                String category;

                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi < 25) {
                    category = "Normal";
                } else if (bmi < 30) {
                    category = "Overweight";
                } else {
                    category = "Obese";
                }

                
                tvBMIResult.setText(
                        "BMI: " + String.format("%.2f", bmi) +
                        "\nCategory: " + category
                );
            }
        });
    }
}
