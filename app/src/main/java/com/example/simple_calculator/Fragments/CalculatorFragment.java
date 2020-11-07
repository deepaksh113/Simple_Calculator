package com.example.simple_calculator.Fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.simple_calculator.Data_Generator;
import com.example.simple_calculator.Database.Data;
import com.example.simple_calculator.MainActivity;
import com.example.simple_calculator.R;
import com.example.simple_calculator.Remote.DataCallBack;
import com.example.simple_calculator.Remote.DataManager;
import com.example.simple_calculator.databinding.FragmentCalculatorBinding;
import java.util.List;
import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_LONG;
import static java.lang.String.format;

public class CalculatorFragment extends Fragment implements View.OnClickListener, DataCallBack {

    private boolean addition, subtraction, multiplication, division, remainder, decimal;
    private Data_Generator dataGenerator;
    private DataManager dataManager;
    private FragmentCalculatorBinding fragmentCalculatorBinding =null;
    Context context=null;

    public CalculatorFragment() {

    }
    public static CalculatorFragment newInstance(int containerId) {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args= new Bundle();
        args.putInt("ContainerId",containerId);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        int containerId;
        super.onCreate(savedInstanceState);
        dataGenerator = new ViewModelProvider(this).get(Data_Generator.class);
        dataManager = new DataManager((MainActivity) context);
        if (getArguments() != null) {
            containerId = getArguments().getInt("ContainerId");
        }
        getActivity().getSupportFragmentManager();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
            fragmentCalculatorBinding = FragmentCalculatorBinding.inflate(inflater,container,false);
            fragmentCalculatorBinding.button2.setOnClickListener(this);
            fragmentCalculatorBinding.button1.setOnClickListener(this);
            fragmentCalculatorBinding.button3.setOnClickListener(this);
            fragmentCalculatorBinding.button4.setOnClickListener(this);
            fragmentCalculatorBinding.button5.setOnClickListener(this);
            fragmentCalculatorBinding.button6.setOnClickListener(this);
            fragmentCalculatorBinding.button7.setOnClickListener(this);
            fragmentCalculatorBinding.button8.setOnClickListener(this);
            fragmentCalculatorBinding.button9.setOnClickListener(this);
            fragmentCalculatorBinding.button0.setOnClickListener(this);
            fragmentCalculatorBinding.buttonAddition.setOnClickListener(this);
            fragmentCalculatorBinding.buttonSubtraction.setOnClickListener(this);
            fragmentCalculatorBinding.buttonMultiplication.setOnClickListener(this);
            fragmentCalculatorBinding.buttonDivision.setOnClickListener(this);
            fragmentCalculatorBinding.buttonRemainder.setOnClickListener(this);
            fragmentCalculatorBinding.buttonDot.setOnClickListener(this);
            fragmentCalculatorBinding.buttonDeletion.setOnClickListener(this);
            fragmentCalculatorBinding.buttonEqual.setOnClickListener(this);
        }catch (Exception e){
            Log.e(TAG,"onCreateView BlankFragment",e);
        }
        return fragmentCalculatorBinding.getRoot();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                fragmentCalculatorBinding.display.setText(format("%s1", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.button2:
                fragmentCalculatorBinding.display.setText(format("%s2", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.button3:
                fragmentCalculatorBinding.display.setText(format("%s3", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.button4:
                fragmentCalculatorBinding.display.setText(format("%s4", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.button5:
                fragmentCalculatorBinding.display.setText(format("%s5", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.button6:
                fragmentCalculatorBinding.display.setText(format("%s6", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.button7:
                fragmentCalculatorBinding.display.setText(format("%s7", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.button8:
                fragmentCalculatorBinding.display.setText(format("%s8", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.button9:
                fragmentCalculatorBinding.display.setText(format("%s9", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.button0:
                fragmentCalculatorBinding.display.setText(format("%s0", fragmentCalculatorBinding.display.getText()));
                break;
            case R.id.buttonAddition:
                if (fragmentCalculatorBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(fragmentCalculatorBinding.display.getText() + "");
                    addition = true;
                    decimal = false;
                    fragmentCalculatorBinding.display.setText(null);
                }
                break;
            case R.id.buttonSubtraction:
                if (fragmentCalculatorBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(fragmentCalculatorBinding.display.getText() + "");
                    subtraction = true;
                    decimal = false;
                    fragmentCalculatorBinding.display.setText(null);
                }
                break;
            case R.id.buttonMultiplication:
                if (fragmentCalculatorBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(fragmentCalculatorBinding.display.getText() + "");
                    multiplication = true;
                    decimal = false;
                    fragmentCalculatorBinding.display.setText(null);
                }
                break;
            case R.id.buttonDivision:
                if (fragmentCalculatorBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(format("%s", fragmentCalculatorBinding.display.getText()));
                    division = true;
                    decimal = false;
                    fragmentCalculatorBinding.display.setText(null);
                }
                break;
            case R.id.buttonRemainder:
                if (fragmentCalculatorBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(format("%s", fragmentCalculatorBinding.display.getText()));
                    remainder = true;
                    decimal = false;
                    fragmentCalculatorBinding.display.setText(null);
                }
                break;
            case R.id.buttonDot:
                if (!decimal) {
                    fragmentCalculatorBinding.display.setText(format("%s.", fragmentCalculatorBinding.display.getText()));
                    decimal = true;
                }
                break;
            case R.id.buttonDeletion:
                fragmentCalculatorBinding.display.setText("");
                dataGenerator.onCleared();
                dataGenerator.firstVariable = 0.0;
                dataGenerator.secondVariable = 0.0;
                break;
            case R.id.buttonEqual:
                if (addition || subtraction || multiplication || division || remainder) {
                    dataGenerator.secondVariable = Float.parseFloat(format("%s", fragmentCalculatorBinding.display.getText()));
                }

                if (addition) {
                    dataGenerator.result=dataGenerator.firstVariable + dataGenerator.secondVariable;
                    fragmentCalculatorBinding.display.setText(format("%s", dataGenerator.result));
                    dataManager.addData(CalculatorFragment.this,dataGenerator.firstVariable,"+",dataGenerator.secondVariable,dataGenerator.result);
                    addition = false;
                }

                if (subtraction) {
                    dataGenerator.result=dataGenerator.firstVariable - dataGenerator.secondVariable;
                    fragmentCalculatorBinding.display.setText(format("%s", dataGenerator.result));
                    dataManager.addData(CalculatorFragment.this,dataGenerator.firstVariable,"-",dataGenerator.secondVariable,dataGenerator.result);
                    subtraction = false;
                }

                if (multiplication) {
                    dataGenerator.result=dataGenerator.firstVariable * dataGenerator.secondVariable;
                    fragmentCalculatorBinding.display.setText(format("%s", dataGenerator.result));
                    dataManager.addData(CalculatorFragment.this,dataGenerator.firstVariable,"*",dataGenerator.secondVariable,dataGenerator.result);
                    multiplication = false;
                }

                if (division) {
                    try{
                        dataGenerator.result=dataGenerator.firstVariable / dataGenerator.secondVariable;
                        fragmentCalculatorBinding.display.setText(format("%s", dataGenerator.result));
                        dataManager.addData(CalculatorFragment.this,dataGenerator.firstVariable,"/",dataGenerator.secondVariable,dataGenerator.result);
                    }
                    catch (ArithmeticException e){
                        Toast.makeText(getActivity(),
                                "You have entered in it wrong pattern or you want to calculate infinity",
                                LENGTH_LONG)
                                .show();}
                    division = false;
                }
                if (remainder) {
                    dataGenerator.result=dataGenerator.firstVariable % dataGenerator.secondVariable;
                    fragmentCalculatorBinding.display.setText(format("%s", dataGenerator.result));
                    dataManager.addData(CalculatorFragment.this,dataGenerator.firstVariable,"%",dataGenerator.secondVariable,dataGenerator.result);
                    remainder = false;
                }
                break;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentCalculatorBinding = null;
    }
    @Override
    public void dataError() {
        showToast("Error on Adding Data to Database");
    }
    @Override
    public void loadData(List<Data> dataList) {
    }

    void showToast(String message){
        Toast.makeText(getActivity(),message, LENGTH_LONG ).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context=null;
    }
}