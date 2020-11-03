package com.example.simple_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.simple_calculator.databinding.ActivityMainBinding;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    private boolean addition, subtract, multiplication, division, remainder, decimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        Data_Generator data = new ViewModelProvider(this).get(Data_Generator.class);

        activityMainBinding.button1.setOnClickListener(v -> activityMainBinding.display.setText(format("%s1", activityMainBinding.display.getText())));

        activityMainBinding.button2.setOnClickListener(v -> activityMainBinding.display.setText(format("%s2", activityMainBinding.display.getText())));

        activityMainBinding.button3.setOnClickListener(v -> activityMainBinding.display.setText(format("%s3", activityMainBinding.display.getText())));

        activityMainBinding.button4.setOnClickListener(v -> activityMainBinding.display.setText(format("%s4", activityMainBinding.display.getText())));

        activityMainBinding.button5.setOnClickListener(v -> activityMainBinding.display.setText(format("%s5", activityMainBinding.display.getText())));

        activityMainBinding.button6.setOnClickListener(v -> activityMainBinding.display.setText(format("%s6", activityMainBinding.display.getText())));

        activityMainBinding.button7.setOnClickListener(v -> activityMainBinding.display.setText(format("%s7", activityMainBinding.display.getText())));

        activityMainBinding.button8.setOnClickListener(v -> activityMainBinding.display.setText(format("%s8", activityMainBinding.display.getText())));

        activityMainBinding.button9.setOnClickListener(v -> activityMainBinding.display.setText(format("%s9", activityMainBinding.display.getText())));

        activityMainBinding.button0.setOnClickListener(v -> activityMainBinding.display.setText(format("%s0", activityMainBinding.display.getText())));

        activityMainBinding.buttonAdditon.setOnClickListener(v -> {
            if (activityMainBinding.display.getText().length() != 0) {
                data.input1 = Float.parseFloat(activityMainBinding.display.getText() + "");
                addition = true;
                decimal = false;
                activityMainBinding.display.setText(null);
            }
        });

        activityMainBinding.buttonSubtraction.setOnClickListener(v -> {
            if (activityMainBinding.display.getText().length() != 0) {
                data.input1 = Float.parseFloat(activityMainBinding.display.getText() + "");
                subtract = true;
                decimal = false;
                activityMainBinding.display.setText(null);
            }
        });

        activityMainBinding.buttonMultiplication.setOnClickListener(v -> {
            if (activityMainBinding.display.getText().length() != 0) {
                data.input1 = Float.parseFloat(activityMainBinding.display.getText() + "");
                multiplication = true;
                decimal = false;
                activityMainBinding.display.setText(null);
            }
        });

        activityMainBinding.buttonDivison.setOnClickListener(v -> {
            if (activityMainBinding.display.getText().length() != 0) {
                data.input1 = Float.parseFloat(format("%s", activityMainBinding.display.getText()));
                division = true;
                decimal = false;
                activityMainBinding.display.setText(null);
            }
        });

        activityMainBinding.remainder.setOnClickListener(v -> {
            if (activityMainBinding.display.getText().length() != 0) {
                data.input1 = Float.parseFloat(format("%s", activityMainBinding.display.getText()));
                remainder = true;
                decimal = false;
                activityMainBinding.display.setText(null);
            }
        });

        activityMainBinding.buttonEqual.setOnClickListener(v -> {
            if (addition || subtract || multiplication || division || remainder) {
                data.input2 = Float.parseFloat(String.format("%s", activityMainBinding.display.getText()));
            }

            if (addition) {

                activityMainBinding.display.setText(format("%s", data.input1 + data.input2));
                addition = false;
            }

            if (subtract) {

                activityMainBinding.display.setText(format("%s", data.input1 - data.input2));
                subtract = false;
            }

            if (multiplication) {
                activityMainBinding.display.setText(format("%s", data.input1 * data.input2));
                multiplication = false;
            }

            if (division) {
                try{activityMainBinding.display.setText(format("%s", data.input1 / data.input2));}
                catch (ArithmeticException e){
                    Toast.makeText(getApplicationContext(),
                        "You have entered in it wrong pattern or you want to calculate infinity",
                        Toast.LENGTH_LONG)
                        .show();}
                division = false;
            }
            if (remainder) {
                activityMainBinding.display.setText(format("%s", data.input1 % data.input2));
                remainder = false;
            }
        });

        activityMainBinding.buttonDeletion.setOnClickListener(v -> {
            activityMainBinding.display.setText("");
            data.onCleared();
            data.input1 = 0.0;
            data.input2 = 0.0;
        });

        activityMainBinding.buttonDot.setOnClickListener(v -> {
            if (!decimal) {
                activityMainBinding.display.setText(format("%s.", activityMainBinding.display.getText()));
                decimal = true;
            }

        });

    }
}