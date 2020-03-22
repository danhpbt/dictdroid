package com.xynotec.dictdroid.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;

import java.util.List;

import io.reactivex.Single;

public interface DataManager {

    Context getContext();

    //DictEngine
    void openDict(String path);
    int numWordInDict();
    int getDictSource();//LINGO_ LINGVOSOFT
    int getSourceLang();
    int getDestinationLang();
    String getDictWord(int index);
    String getMeanWord(int index);
    int onDictSearch(String word);

    //AppPreferences
    void setZoomScale(int scale);
    int getZoomScale();

    void setQZoomScale(int scale);
    int getQZoomScale();

    void setAutoLookup(boolean bAutoLookup);
    boolean getAutoLookup();

    void setSwapDict(boolean bSwap);
    boolean getSwapDict();
    void setFromLangRecentIndex(int index);
    int getFromLangRecentIndex();
    void setToLangRecentIndex(int index);
    int getToLangRecentIndex();


    //LocalDataBase
    void insertHistory(History history);
    void deleteHistory(String word);
    LiveData<List<History>> getHistories();

    void insertFavorite(Favorite favorite);
    void deleteFavorite(String word);
    LiveData<List<Favorite>> getFavorites();
    boolean existFavorite(String word);

    //Request Api
    Single<String> doTranslateApiCall(String url);




}
