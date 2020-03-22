package com.xynotec.dictdroid.data;

import androidx.lifecycle.LiveData;

import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;

import java.util.List;

import io.reactivex.Single;

public interface DataManager {

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
    int getZoomScale();
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
