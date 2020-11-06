package com.example.simple_calculator.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface DataDao {
    @Query("select * from Data")
    Flowable<List<Data>> getData();

    @Insert
    void insertData(Data data);

    @Delete
    boolean deleteData();
}
