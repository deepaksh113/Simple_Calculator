package com.example.simple_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simple_calculator.databinding.ActivityMainBinding;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    private double input1 = 0, input2 = 0;
    private TextView editText;
    private boolean addition, subtract, multiplication, division, remainder, decimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        editText = activityMainBinding.display;

        activityMainBinding.button1.setOnClickListener(v -> editText.setText(format("%s1", editText.getText())));

        activityMainBinding.button2.setOnClickListener(v -> editText.setText(format("%s2", editText.getText())));

        activityMainBinding.button3.setOnClickListener(v -> editText.setText(format("%s3", editText.getText())));

        activityMainBinding.button4.setOnClickListener(v -> editText.setText(format("%s4", editText.getText())));

        activityMainBinding.button5.setOnClickListener(v -> editText.setText(format("%s5", editText.getText())));

        activityMainBinding.button6.setOnClickListener(v -> editText.setText(format("%s6", editText.getText())));

        activityMainBinding.button7.setOnClickListener(v -> editText.setText(format("%s7", editText.getText())));

        activityMainBinding.button8.setOnClickListener(v -> editText.setText(format("%s8", editText.getText())));

        activityMainBinding.button9.setOnClickListener(v -> editText.setText(format("%s9", editText.getText())));

        activityMainBinding.button0.setOnClickListener(v -> editText.setText(format("%s0", editText.getText())));

        activityMainBinding.buttonAdditon.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(editText.getText() + "");
                addition = true;
                decimal = false;
                editText.setText(null);
            }
        });

        activityMainBinding.buttonSubtraction.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(editText.getText() + "");
                subtract = true;
                decimal = false;
                editText.setText(null);
            }
        });

        activityMainBinding.buttonMultiplication.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(editText.getText() + "");
                multiplication = true;
                decimal = false;
                editText.setText(null);
            }
        });

        activityMainBinding.buttonDivison.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(format("%s", editText.getText()));
                division = true;
                decimal = false;
                editText.setText(null);
            }
        });

        activityMainBinding.remainder.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(format("%s", editText.getText()));
                remainder = true;
                decimal = false;
                editText.setText(null);
            }
        });

        activityMainBinding.buttonEqual.setOnClickListener(v -> {
            if (addition || subtract || multiplication || division || remainder) {
                input2 = Float.parseFloat(String.format("%s", editText.getText()));
            }

            if (addition) {

                editText.setText(format("%s", input1 + input2));
                addition = false;
            }

            if (subtract) {

                editText.setText(format("%s", input1 - input2));
                subtract = false;
            }

            if (multiplication) {
                editText.setText(format("%s", input1 * input2));
                multiplication = false;
            }

            if (division) {
                try{editText.setText(format("%s", input1 / input2));}
                catch (ArithmeticException e){
                    Toast.makeText(getApplicationContext(),
                        "You have entered in it wrong pattern or you want to calculate infinity",
                        Toast.LENGTH_LONG)
                        .show();}
                division = false;
            }
            if (remainder) {
                editText.setText(format("%s", input1 % input2));
                remainder = false;
            }
        });

        activityMainBinding.buttonDeletion.setOnClickListener(v -> {
            editText.setText("");
            input1 = 0.0;
            input2 = 0.0;
        });

        activityMainBinding.buttonDot.setOnClickListener(v -> {
            if (!decimal) {
                editText.setText(format("%s.", editText.getText()));
                decimal = true;
            }

        });

    }
}