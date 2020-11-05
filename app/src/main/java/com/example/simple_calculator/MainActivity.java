package com.example.simple_calculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.example.simple_calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    protected ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        BlankFragment blankFragment= BlankFragment.newInstance(activityMainBinding.fragmentContainer.getId());
        FragmentTransaction blankFragmentTransaction=getSupportFragmentManager().beginTransaction();
        blankFragmentTransaction.replace(activityMainBinding.fragmentContainer.getId(), blankFragment,"BlankFragmentTag").addToBackStack(null).commit();
    }
}