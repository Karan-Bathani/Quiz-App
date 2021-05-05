package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etAnswer1;
    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private CheckBox checkbox3;
    private RadioButton radio_212mph;
    private RadioButton radio_2012;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAnswer1 = findViewById(R.id.et_Ans_1);

        radio_212mph = findViewById(R.id.radio_212mph);

        checkbox1 = findViewById(R.id.checkbox_1);
        checkbox2 = findViewById(R.id.checkbox_2);
        checkbox3 = findViewById(R.id.checkbox_3);

        radio_2012 = findViewById(R.id.radio_2012);

    }

    private int calculateScore() {
        score = 0;
        String answer1 = etAnswer1.getText().toString().trim().toLowerCase();
        if (answer1.equals("urus"))
            score += 10;

        if (radio_212mph.isChecked())
            score += 10;

        if (checkbox1.isChecked() && !checkbox2.isChecked() && checkbox3.isChecked())
            score += 10;

        if (radio_2012.isChecked())
            score += 10;

        return score;
    }

    public void onSubmit(View view) {
        int finalscore = calculateScore();
        if (finalscore == 40) {
            Toast.makeText(this, "Congratulations! All answers are correct.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Your Score is: " + finalscore + "/40", Toast.LENGTH_SHORT).show();
        }
    }
}