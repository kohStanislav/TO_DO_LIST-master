package com.staskoh.todolist;

import android.app.Application;

import androidx.room.Room;

import com.staskoh.todolist.data.AppDatabase;
import com.staskoh.todolist.data.ListDao;

public class ListApp extends Application {

    private AppDatabase database;
    private ListDao listDao;

    private static ListApp instance;

    public static ListApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-db-name")
                .allowMainThreadQueries()
                .build();

        listDao = database.noteDao();
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public ListDao getNoteDao() {
        return listDao;
    }

    public void setNoteDao(ListDao listDao) {
        this.listDao = listDao;
    }
}
