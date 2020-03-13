package com.xynotec.dictdroid.data.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class History extends RealmObject {
    @PrimaryKey
    @Required //not null
    private String compoundKey;

    private int dictLang;

    @Required //not null
    private String word;

    @Required //not null
    private String mean;

    public History()
    {

    }

    public void setWordMean(String word, String mean, int dictLang)
    {
        this.dictLang = dictLang;
        this.word = word;
        this.mean = mean;
        this.compoundKey = String.format("%d_%s", dictLang, word);
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
