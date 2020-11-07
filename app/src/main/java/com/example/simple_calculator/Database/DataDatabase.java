package com.example.simple_calculator.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Data.class,version = 1)
public abstract class DataDatabase extends RoomDatabase {
    public abstract DataDao getDataDao();
}
