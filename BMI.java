package com.example.bmiactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI extends AppCompatActivity {
    EditText edtText1, edtText2, edtText3, edtText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);

        edtText1 = findViewById(R.id.edt1);
        edtText2 = findViewById(R.id.edt2);
        edtText3 = findViewById(R.id.edt3);
        edtText4 = findViewById(R.id.edt4);

        findViewById(R.id.calculate).setOnClickListener(v -> {
            try {
                // Create object for bmi class
                BmiActivity bmiactivity = new BmiActivity();

                // Read the values from weight and height
                bmiactivity.weight = Double.parseDouble(edtText1.getText().toString());
                bmiactivity.height = Double.parseDouble(edtText2.getText().toString());

                Double finalBmi = bmiactivity.CalculateBMI(bmiactivity.weight, bmiactivity.height);

                // Display the value of bmi on the edit text
                edtText3.setText(finalBmi.toString());
                edtText4.setText(HealthStatus(finalBmi));

                Toast.makeText(this, "Class Worked Well", Toast.LENGTH_SHORT).show();

                // Uncomment if you want to navigate to another activity after calculation
                // Intent intent = new Intent(getApplicationContext(), Grading.class);
                // startActivity(intent);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public String HealthStatus(double bmi) {
        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi > 18.5 && bmi < 27.0) {
            return "Healthy";
        } else {
            return "Obese";
        }
    }
}
