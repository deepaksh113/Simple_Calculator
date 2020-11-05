package com.example.simple_calculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.simple_calculator.databinding.FragmentBlankBinding;

import static android.content.ContentValues.TAG;
import static com.example.simple_calculator.R.id.button0;
import static com.example.simple_calculator.R.id.button1;
import static com.example.simple_calculator.R.id.button2;
import static com.example.simple_calculator.R.id.button3;
import static com.example.simple_calculator.R.id.button4;
import static com.example.simple_calculator.R.id.button5;
import static com.example.simple_calculator.R.id.button6;
import static com.example.simple_calculator.R.id.button7;
import static com.example.simple_calculator.R.id.button8;
import static com.example.simple_calculator.R.id.button9;
import static com.example.simple_calculator.R.id.buttonAdditon;
import static com.example.simple_calculator.R.id.buttonDeletion;
import static com.example.simple_calculator.R.id.buttonDivison;
import static com.example.simple_calculator.R.id.buttonDot;
import static com.example.simple_calculator.R.id.buttonEqual;
import static com.example.simple_calculator.R.id.buttonMultiplication;
import static com.example.simple_calculator.R.id.buttonRemainder;
import static com.example.simple_calculator.R.id.buttonSubtraction;
import static java.lang.String.format;

public class BlankFragment extends Fragment implements View.OnClickListener {

    private boolean addition, subtract, multiplication, division, remainder, decimal;
    private Data_Generator data;
    private FragmentBlankBinding fragmentBlankBinding=null;
    public BlankFragment() {

    }

    public static BlankFragment newInstance(int containerId) {
        BlankFragment fragment = new BlankFragment();
        Bundle args= new Bundle();
        args.putInt("ContainerId",containerId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        int containerId;
        super.onCreate(savedInstanceState);
        data = new ViewModelProvider(this).get(Data_Generator.class);
        if (getArguments() != null) {
            containerId = getArguments().getInt("ContainerId");
        }
        getActivity().getSupportFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
            fragmentBlankBinding = FragmentBlankBinding.inflate(inflater,container,false);
            fragmentBlankBinding.button2.setOnClickListener(this);
            fragmentBlankBinding.button1.setOnClickListener(this);
            fragmentBlankBinding.button3.setOnClickListener(this);
            fragmentBlankBinding.button4.setOnClickListener(this);
            fragmentBlankBinding.button5.setOnClickListener(this);
            fragmentBlankBinding.button6.setOnClickListener(this);
            fragmentBlankBinding.button7.setOnClickListener(this);
            fragmentBlankBinding.button8.setOnClickListener(this);
            fragmentBlankBinding.button9.setOnClickListener(this);
            fragmentBlankBinding.button0.setOnClickListener(this);
            fragmentBlankBinding.buttonAdditon.setOnClickListener(this);
            fragmentBlankBinding.buttonSubtraction.setOnClickListener(this);
            fragmentBlankBinding.buttonMultiplication.setOnClickListener(this);
            fragmentBlankBinding.buttonDivison.setOnClickListener(this);
            fragmentBlankBinding.buttonRemainder.setOnClickListener(this);
            fragmentBlankBinding.buttonDot.setOnClickListener(this);
            fragmentBlankBinding.buttonDeletion.setOnClickListener(this);
            fragmentBlankBinding.buttonEqual.setOnClickListener(this);
        }catch (Exception e){
            Log.e(TAG,"onCreateView",e);
        }
        return fragmentBlankBinding.getRoot();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case button1:
                fragmentBlankBinding.display.setText(format("%s1", fragmentBlankBinding.display.getText()));
                break;
            case button2:
                fragmentBlankBinding.display.setText(format("%s2",fragmentBlankBinding.display.getText()));
                break;
            case button3:
                fragmentBlankBinding.display.setText(format("%s3",fragmentBlankBinding.display.getText()));
                break;
            case button4:
                fragmentBlankBinding.display.setText(format("%s4",fragmentBlankBinding.display.getText()));
                break;
            case button5:
                fragmentBlankBinding.display.setText(format("%s5",fragmentBlankBinding.display.getText()));
                break;
            case button6:
                fragmentBlankBinding.display.setText(format("%s6",fragmentBlankBinding.display.getText()));
                break;
            case button7:
                fragmentBlankBinding.display.setText(format("%s7",fragmentBlankBinding.display.getText()));
                break;
            case button8:
                fragmentBlankBinding.display.setText(format("%s8",fragmentBlankBinding.display.getText()));
                break;
            case button9:
                fragmentBlankBinding.display.setText(format("%s9",fragmentBlankBinding.display.getText()));
                break;
            case button0:
                fragmentBlankBinding.display.setText(format("%s0",fragmentBlankBinding.display.getText()));
                break;
            case buttonAdditon:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    data.input1 = Float.parseFloat(fragmentBlankBinding.display.getText() + "");
                    addition = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case buttonSubtraction:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    data.input1 = Float.parseFloat(fragmentBlankBinding.display.getText() + "");
                    subtract = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case buttonMultiplication:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    data.input1 = Float.parseFloat(fragmentBlankBinding.display.getText() + "");
                    multiplication = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case buttonDivison:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    data.input1 = Float.parseFloat(format("%s", fragmentBlankBinding.display.getText()));
                    division = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case buttonRemainder:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    data.input1 = Float.parseFloat(format("%s", fragmentBlankBinding.display.getText()));
                    remainder = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case buttonDot:
                if (!decimal) {
                    fragmentBlankBinding.display.setText(format("%s.", fragmentBlankBinding.display.getText()));
                    decimal = true;
                }
                break;
            case buttonDeletion:
                fragmentBlankBinding.display.setText("");
                data.onCleared();
                data.input1 = 0.0;
                data.input2 = 0.0;
                break;
            case buttonEqual:
                if (addition || subtract || multiplication || division || remainder) {
                    data.input2 = Float.parseFloat(format("%s", fragmentBlankBinding.display.getText()));
                }

                if (addition) {

                    fragmentBlankBinding.display.setText(format("%s", data.input1 + data.input2));
                    addition = false;
                }

                if (subtract) {

                    fragmentBlankBinding.display.setText(format("%s", data.input1 - data.input2));
                    subtract = false;
                }

                if (multiplication) {
                    fragmentBlankBinding.display.setText(format("%s", data.input1 * data.input2));
                    multiplication = false;
                }

                if (division) {
                    try{fragmentBlankBinding.display.setText(format("%s", data.input1 / data.input2));}
                    catch (ArithmeticException e){
                        Toast.makeText(getActivity(),
                                "You have entered in it wrong pattern or you want to calculate infinity",
                                Toast.LENGTH_LONG)
                                .show();}
                    division = false;
                }
                if (remainder) {
                    fragmentBlankBinding.display.setText(format("%s", data.input1 % data.input2));
                    remainder = false;
                }
                break;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentBlankBinding = null;
    }
}