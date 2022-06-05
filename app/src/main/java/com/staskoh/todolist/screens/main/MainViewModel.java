package com.staskoh.todolist.screens.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.staskoh.todolist.ListApp;
import com.staskoh.todolist.model.list;

import java.util.List;

public class MainViewModel extends ViewModel {
    private LiveData<List<list>> listLiveData = ListApp.getInstance().getNoteDao().getAllLiveData();

    public LiveData<List<list>> getListLiveData() {
        return listLiveData;
    }
}
