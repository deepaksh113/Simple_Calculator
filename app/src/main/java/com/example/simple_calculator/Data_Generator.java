package com.example.simple_calculator;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class Data_Generator extends ViewModel {
    public double firstVariable = 0, secondVariable = 0, result = 0;
    private final String TAG= this.getClass().getSimpleName();
    @Override
    public void onCleared() {
        super.onCleared();
        Log.i(TAG,"Data Deleted");
    }
}
