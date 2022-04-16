package com.example.p2;

public class Item {

    // create img id, name, count
    private int imgId;
    private int voteCount;
    private String name;

    public Item(int imgId, int voteCount, String name) {
        this.imgId = imgId;
        this.voteCount = voteCount;
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
