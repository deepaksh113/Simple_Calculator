package com.example.simple_calculator.Remote;

import android.content.Context;
import androidx.lifecycle.Observer;
import androidx.room.Room;
import com.example.simple_calculator.Fragments.HistoryFragment;
import com.example.simple_calculator.Database.Data;
import com.example.simple_calculator.Database.DataDatabase;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DataManager {
    private Context context;
    private DataDatabase dataDatabase;

    public DataManager(Context context){
        this.context=context;
        dataDatabase= Room.databaseBuilder(context,DataDatabase.class,"data.db").build();

    }
    public void addData(final DataCallBack dataCallBack,final double firstVariable,final String operator,final double secondVariable, final double result){
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Throwable {
            Data data = new Data(firstVariable,operator,secondVariable,result);
            dataDatabase.getDataDao().insertData(data);
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
        HistoryFragment historyFragment = new HistoryFragment();
        dataDatabase.getDataDao().getData().observe(historyFragment, new Observer<List<Data>>() {
            @Override
            public void onChanged(List<Data> dataList) {
                dataCallBack.loadData(dataList);
            }
        });
    }
}
