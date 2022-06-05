package com.staskoh.todolist.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.staskoh.todolist.model.list;

import java.util.List;

@Dao
public interface ListDao {

    @Query("SELECT * FROM list")
    List<list> getAll();

    @Query("SELECT * FROM list")
    LiveData<List<list>> getAllLiveData();

    @Query("SELECT * FROM list WHERE uid IN (:noteIds)")
    List<list> loadAllByIds(int[] noteIds);

    @Query("SELECT * FROM list WHERE uid = :uid LIMIT 1")
    list findById(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(list list);

    @Update
    void update(list list);

    @Delete
    void delete(list list);

}
