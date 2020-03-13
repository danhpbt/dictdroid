package com.xynotec.dictdroid.data;

public interface DataManager {

    //DictEngine
    public abstract void openDict(String path);
    public abstract int numWordInDict();
    public abstract int getDictSource();
    public abstract String getDictWord(int index);
    public abstract String getMeanWord(int index);
    public abstract int onDictSearch(String word);

    //AppPreferences
    public abstract int getZoomScale();

}
