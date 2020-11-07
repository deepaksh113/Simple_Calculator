package com.example.simple_calculator.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface DataDao {
    @Query("select * from Data")
    LiveData<List<Data>> getData();

    @Insert
    void insertData(Data data);
}
