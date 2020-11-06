package com.example.simple_calculator.Remote;

import android.content.Context;

import androidx.room.Room;

import com.example.simple_calculator.BlankFragment;
import com.example.simple_calculator.Database.Data;
import com.example.simple_calculator.Database.dataDatabase;
import com.example.simple_calculator.MainActivity;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DataManager {
    private Context context;
    private dataDatabase dataDatabase1;

    public DataManager(MainActivity context){
        this.context=context;
        dataDatabase1= Room.databaseBuilder(context,dataDatabase.class,"data.db").build();
    }
    public void addData(final DataCallBack dataCallBack,final double firstVariable,final String operator,final double secondVariable, final double result){
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Throwable {
            Data data = new Data(firstVariable,operator,secondVariable,result);
            dataDatabase1.getDataDao().insertData(data);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }
            @Override
            public void onComplete(){}
            @Override
            public void onError(@NonNull Throwable e) {
                dataCallBack.dataError();
            }
        });
    }
    public void loadData(final DataCallBack dataCallBack){
        dataDatabase1.getDataDao().getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Data>>() {
            @Override
            public void accept(List<Data> dataList) throws Throwable {
                dataCallBack.loadData(dataList);
            }
        });
    }
}
