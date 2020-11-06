package com.example.simple_calculator;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.simple_calculator.Database.Data;
import com.example.simple_calculator.Remote.DataCallBack;
import com.example.simple_calculator.Remote.DataManager;
import com.example.simple_calculator.databinding.FragmentBlankBinding;
import java.util.List;
import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_LONG;
import static java.lang.String.format;

public class BlankFragment extends Fragment implements View.OnClickListener, DataCallBack {

    private boolean addition, subtraction, multiplication, division, remainder, decimal;
    private Data_Generator dataGenerator;
    private DataManager dataManager;
    private FragmentBlankBinding fragmentBlankBinding=null;
    Context context=null;
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
            case R.id.button1:
                fragmentBlankBinding.display.setText(format("%s1", fragmentBlankBinding.display.getText()));
                break;
            case R.id.button2:
                fragmentBlankBinding.display.setText(format("%s2",fragmentBlankBinding.display.getText()));
                break;
            case R.id.button3:
                fragmentBlankBinding.display.setText(format("%s3",fragmentBlankBinding.display.getText()));
                break;
            case R.id.button4:
                fragmentBlankBinding.display.setText(format("%s4",fragmentBlankBinding.display.getText()));
                break;
            case R.id.button5:
                fragmentBlankBinding.display.setText(format("%s5",fragmentBlankBinding.display.getText()));
                break;
            case R.id.button6:
                fragmentBlankBinding.display.setText(format("%s6",fragmentBlankBinding.display.getText()));
                break;
            case R.id.button7:
                fragmentBlankBinding.display.setText(format("%s7",fragmentBlankBinding.display.getText()));
                break;
            case R.id.button8:
                fragmentBlankBinding.display.setText(format("%s8",fragmentBlankBinding.display.getText()));
                break;
            case R.id.button9:
                fragmentBlankBinding.display.setText(format("%s9",fragmentBlankBinding.display.getText()));
                break;
            case R.id.button0:
                fragmentBlankBinding.display.setText(format("%s0",fragmentBlankBinding.display.getText()));
                break;
            case R.id.buttonAdditon:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(fragmentBlankBinding.display.getText() + "");
                    addition = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case R.id.buttonSubtraction:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(fragmentBlankBinding.display.getText() + "");
                    subtraction = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case R.id.buttonMultiplication:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(fragmentBlankBinding.display.getText() + "");
                    multiplication = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case R.id.buttonDivison:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(format("%s", fragmentBlankBinding.display.getText()));
                    division = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case R.id.buttonRemainder:
                if (fragmentBlankBinding.display.getText().length() != 0) {
                    dataGenerator.firstVariable = Float.parseFloat(format("%s", fragmentBlankBinding.display.getText()));
                    remainder = true;
                    decimal = false;
                    fragmentBlankBinding.display.setText(null);
                }
                break;
            case R.id.buttonDot:
                if (!decimal) {
                    fragmentBlankBinding.display.setText(format("%s.", fragmentBlankBinding.display.getText()));
                    decimal = true;
                }
                break;
            case R.id.buttonDeletion:
                fragmentBlankBinding.display.setText("");
                dataGenerator.onCleared();
                dataGenerator.firstVariable = 0.0;
                dataGenerator.secondVariable = 0.0;
                break;
            case R.id.buttonEqual:
                if (addition || subtraction || multiplication || division || remainder) {
                    dataGenerator.secondVariable = Float.parseFloat(format("%s", fragmentBlankBinding.display.getText()));
                }

                if (addition) {
                    dataGenerator.result=dataGenerator.firstVariable + dataGenerator.secondVariable;
                    fragmentBlankBinding.display.setText(format("%s", dataGenerator.result));
                    dataManager.addData(BlankFragment.this,dataGenerator.firstVariable,"+",dataGenerator.secondVariable,dataGenerator.result);
                    addition = false;
                }

                if (subtraction) {
                    dataGenerator.result=dataGenerator.firstVariable - dataGenerator.secondVariable;
                    fragmentBlankBinding.display.setText(format("%s", dataGenerator.result));
                    dataManager.addData(BlankFragment.this,dataGenerator.firstVariable,"-",dataGenerator.secondVariable,dataGenerator.result);
                    subtraction = false;
                }

                if (multiplication) {
                    dataGenerator.result=dataGenerator.firstVariable * dataGenerator.secondVariable;
                    fragmentBlankBinding.display.setText(format("%s", dataGenerator.result));
                    dataManager.addData(BlankFragment.this,dataGenerator.firstVariable,"*",dataGenerator.secondVariable,dataGenerator.result);
                    multiplication = false;
                }

                if (division) {
                    try{
                        dataGenerator.result=dataGenerator.firstVariable / dataGenerator.secondVariable;
                        fragmentBlankBinding.display.setText(format("%s", dataGenerator.result));
                        dataManager.addData(BlankFragment.this,dataGenerator.firstVariable,"/",dataGenerator.secondVariable,dataGenerator.result);
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
                    fragmentBlankBinding.display.setText(format("%s", dataGenerator.result));
                    dataManager.addData(BlankFragment.this,dataGenerator.firstVariable,"%",dataGenerator.secondVariable,dataGenerator.result);
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