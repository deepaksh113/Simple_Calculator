package com.example.simple_calculator;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class Data_Generator extends ViewModel {
    public double input1 = 0, input2 = 0;
    private final String TAG= this.getClass().getSimpleName();
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG,"Data Deleted");
    }
}
