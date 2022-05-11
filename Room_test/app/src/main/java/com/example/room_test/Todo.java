package com.example.room_test;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo {
    // ID를 직접 주지 않고 자동으로 PrimaryKey로 생성.
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;

    public Todo(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
