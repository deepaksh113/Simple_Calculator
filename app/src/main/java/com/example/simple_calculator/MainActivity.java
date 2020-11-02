package com.example.simple_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    double input1 = 0, input2 = 0;
    private TextView editText;
    private boolean addition, subtract, multiplication, division, remainder, decimal;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAddition, buttonSubtraction,
            buttonMultiplication, buttonDivision, buttonEqual, buttonDeletion, buttonDot, remainder1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonAddition = (Button) findViewById(R.id.buttonadditon);
        buttonSubtraction = (Button) findViewById(R.id.buttonsubtraction);
        buttonMultiplication = (Button) findViewById(R.id.buttonmultiplication);
        buttonDivision = (Button) findViewById(R.id.buttondivison);
        remainder1 = (Button) findViewById(R.id.Remainder);
        buttonDeletion = (Button) findViewById(R.id.buttonDeletion);
        buttonEqual = (Button) findViewById(R.id.buttonequal);

        editText = (TextView) findViewById(R.id.display);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s1", editText.getText()));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s2", editText.getText()));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s3", editText.getText()));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s4", editText.getText()));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s5", editText.getText()));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s6", editText.getText()));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s7", editText.getText()));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s8", editText.getText()));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s9", editText.getText()));
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(format("%s0", editText.getText()));
            }
        });

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().length() != 0) {
                    input1 = Float.parseFloat(editText.getText() + "");
                    addition = true;
                    decimal = false;
                    editText.setText(null);
                }
            }
        });

        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().length() != 0) {
                    input1 = Float.parseFloat(editText.getText() + "");
                    subtract = true;
                    decimal = false;
                    editText.setText(null);
                }
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().length() != 0) {
                    input1 = Float.parseFloat(editText.getText() + "");
                    multiplication = true;
                    decimal = false;
                    editText.setText(null);
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().length() != 0) {
                    input1 = Float.parseFloat(format("%s", editText.getText()));
                    division = true;
                    decimal = false;
                    editText.setText(null);
                }
            }
        });

        remainder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().length() != 0) {
                    input1 = Float.parseFloat(format("%s", editText.getText()));
                    remainder = true;
                    decimal = false;
                    editText.setText(null);
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    editText.setText(format("%s", input1 / input2));
                    division = false;
                }
                if (remainder) {
                    editText.setText(format("%s", input1 % input2));
                    remainder = false;
                }
            }
        });

        buttonDeletion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                input1 = 0.0;
                input2 = 0.0;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!decimal) {
                    editText.setText(format("%s.", editText.getText()));
                    decimal = true;
                }

            }
        });

    }
}