package com.xynotec.dictdroid.data.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Favorite extends RealmObject {
    @PrimaryKey
    @Required //not null
    private String word;

    @Required //not null
    private String mean;

    public Favorite()
    {
        word = "";
        mean = "";
    }

    public Favorite(String word, String mean)
    {
        this.word = word;
        this.mean = mean;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
