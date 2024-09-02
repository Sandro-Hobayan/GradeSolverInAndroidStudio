package com.example.androidfundamentals;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvOutputPof, tvAverage;
    EditText prelim, midterm, finals;
    Button btnCompute, btnclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        prelim = findViewById(R.id.et_prelim);
        midterm = findViewById(R.id.et_midterm);
        finals = findViewById(R.id.et_finals);
        tvOutputPof = findViewById(R.id.tv_outputpof);
        tvAverage = findViewById(R.id.tv_output);

        btnCompute = findViewById(R.id.btn_compute);
        btnCompute.setOnClickListener(view -> {
            String prelimValue = prelim.getText().toString();
            String midtermValue = midterm.getText().toString();
            String finalsValue = finals.getText().toString();

            int prelimScore = Integer.parseInt(prelimValue);
            int midtermScore = Integer.parseInt(midtermValue);
            int finalsScore = Integer.parseInt(finalsValue);

            int sum = prelimScore + midtermScore + finalsScore;
            int average = sum / 3;

            String result;

            if (average >= 76) {
                result = "You've passed!";
            } else {
                result = "You've failed";
            }

            tvOutputPof.setText(result);
            tvAverage.setText("Your total average: " + String.valueOf(average));
        });

        btnclear = findViewById(R.id.btn_clear);
        btnclear.setOnClickListener(view -> {
            tvOutputPof.setText("Grade Solver");
            tvAverage.setText("");
            prelim.setText("");
            midterm.setText("");
            finals.setText("");
        });
    }
}
