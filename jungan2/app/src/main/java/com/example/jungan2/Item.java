package com.example.jungan2;

public class Item {

    private int imaId;
    private int count;
    private String name;

    public int getImaId() {
        return imaId;
    }

    public void setImaId(int imaId) {
        this.imaId = imaId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(int imaId, int count, String name) {
        this.imaId = imaId;
        this.count = count;
        this.name = name;
    }
}
