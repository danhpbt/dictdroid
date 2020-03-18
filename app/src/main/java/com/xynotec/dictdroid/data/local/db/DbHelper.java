package com.xynotec.dictdroid.data.local.db;

import androidx.lifecycle.LiveData;

import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;

import java.util.List;

public interface DbHelper {
    LiveData<List<History>> getHistories(int sourceLang);
    LiveData<List<Favorite>> getFavorites(int sourceLang);
    void insertHistory(History history);
    void insertFavorite(Favorite favorite);
    void deleteFavorite(String word, int sourceLang);
    boolean existHistory(String history);
    boolean existFavorite(String favorite, int sourceLang);
}
