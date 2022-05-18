package com.example.room_test04;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Dao {

    @Query("SELECT * FROM Todo")
    List<Todo> getAll();

}
