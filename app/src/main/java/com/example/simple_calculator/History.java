package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.simple_calculator.Adaptar.CustomAdapter;
import com.example.simple_calculator.Database.Data;
import com.example.simple_calculator.Remote.DataCallBack;
import com.example.simple_calculator.Remote.DataManager;
import com.example.simple_calculator.databinding.ActivityHistoryBinding;

import java.util.List;

public class History extends AppCompatActivity implements DataCallBack {
    protected ActivityHistoryBinding activityHistoryBinding;
    private ListView listView;
    private CustomAdapter customAdapter;
    private DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHistoryBinding=ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(activityHistoryBinding.getRoot());
        dataManager.loadData(History.this);
    }

    @Override
    public void dataError() {

    }

    @Override
    public void loadData(List<Data> dataList) {
        customAdapter= new CustomAdapter(this,dataList);
        listView.setAdapter(customAdapter);
    }
}