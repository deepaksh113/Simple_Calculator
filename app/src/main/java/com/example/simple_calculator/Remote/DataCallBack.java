package com.example.simple_calculator.Remote;

import com.example.simple_calculator.Database.Data;

import java.util.List;

public interface DataCallBack {
    public void dataError();
    public void loadData(List<Data> dataList);
}
