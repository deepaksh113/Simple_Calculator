package com.example.simple_calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    private double input1 = 0, input2 = 0;
    private TextView editText;
    private boolean addition, subtract, multiplication, division, remainder, decimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button buttonDot = (Button) findViewById(R.id.buttonDot);
        Button buttonAddition = (Button) findViewById(R.id.buttonadditon);
        Button buttonSubtraction = (Button) findViewById(R.id.buttonsubtraction);
        Button buttonMultiplication = (Button) findViewById(R.id.buttonmultiplication);
        Button buttonDivision = (Button) findViewById(R.id.buttondivison);
        Button remainder1 = (Button) findViewById(R.id.Remainder);
        Button buttonDeletion = (Button) findViewById(R.id.buttonDeletion);
        Button buttonEqual = (Button) findViewById(R.id.buttonequal);

        editText = (TextView) findViewById(R.id.display);

        button1.setOnClickListener(v -> editText.setText(format("%s1", editText.getText())));

        button2.setOnClickListener(v -> editText.setText(format("%s2", editText.getText())));

        button3.setOnClickListener(v -> editText.setText(format("%s3", editText.getText())));

        button4.setOnClickListener(v -> editText.setText(format("%s4", editText.getText())));

        button5.setOnClickListener(v -> editText.setText(format("%s5", editText.getText())));

        button6.setOnClickListener(v -> editText.setText(format("%s6", editText.getText())));

        button7.setOnClickListener(v -> editText.setText(format("%s7", editText.getText())));

        button8.setOnClickListener(v -> editText.setText(format("%s8", editText.getText())));

        button9.setOnClickListener(v -> editText.setText(format("%s9", editText.getText())));

        button0.setOnClickListener(v -> editText.setText(format("%s0", editText.getText())));

        buttonAddition.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(editText.getText() + "");
                addition = true;
                decimal = false;
                editText.setText(null);
            }
        });

        buttonSubtraction.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(editText.getText() + "");
                subtract = true;
                decimal = false;
                editText.setText(null);
            }
        });

        buttonMultiplication.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(editText.getText() + "");
                multiplication = true;
                decimal = false;
                editText.setText(null);
            }
        });

        buttonDivision.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(format("%s", editText.getText()));
                division = true;
                decimal = false;
                editText.setText(null);
            }
        });

        remainder1.setOnClickListener(v -> {
            if (editText.getText().length() != 0) {
                input1 = Float.parseFloat(format("%s", editText.getText()));
                remainder = true;
                decimal = false;
                editText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(v -> {
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

        buttonDeletion.setOnClickListener(v -> {
            editText.setText("");
            input1 = 0.0;
            input2 = 0.0;
        });

        buttonDot.setOnClickListener(v -> {
            if (!decimal) {
                editText.setText(format("%s.", editText.getText()));
                decimal = true;
            }

        });

    }
}