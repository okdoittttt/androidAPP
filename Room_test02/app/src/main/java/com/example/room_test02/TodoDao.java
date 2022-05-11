package com.example.room_test02;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("select * from todo")
    List<Todo> getAll();
}
