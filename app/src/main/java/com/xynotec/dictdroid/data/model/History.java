package com.xynotec.dictdroid.data.model;


import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class History extends RealmObject {

    @PrimaryKey
    @Required //not null
    String compoundKey;

    private int dictLang;

    @Required //not null
    String word;

    @Required //not null
    String mean;

    @Required //not null
    Date dateTime;

    public void setWordMean(String word, String mean, int dictLang)
    {
        this.dictLang = dictLang;
        this.word = word;
        this.mean = mean;
        this.compoundKey = String.format("%d_%s", dictLang, word);
        this.dateTime = new Date();
    }

    public String getWord()
    {
        return word;
    }

    public String getMean()
    {
        return mean;
    }

    public Date getDateTime()
    {
        return dateTime;
    }

    public int getDictLang()
    {
        return dictLang;
    }

}
