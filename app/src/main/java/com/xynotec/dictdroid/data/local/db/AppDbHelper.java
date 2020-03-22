package com.xynotec.dictdroid.data.local.db;

import androidx.lifecycle.LiveData;

import com.xynotec.dictdroid.data.local.dao.FavoriteDao;
import com.xynotec.dictdroid.data.local.dao.HistoryDao;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;

import java.util.List;

import javax.inject.Inject;

public class AppDbHelper implements DbHelper {

    @Inject
    FavoriteDao favoriteDao;

    @Inject
    HistoryDao historyDao;

    @Inject
    public AppDbHelper()
    {

    }

    @Override
    public LiveData<List<History>> getHistories(int sourceLang) {
        return historyDao.get(sourceLang);
    }

    @Override
    public LiveData<List<Favorite>> getFavorites(int sourceLang) {
        return favoriteDao.get(sourceLang);
    }

    @Override
    public void insertHistory(History history) {
        historyDao.insert(history);
    }

    @Override
    public void insertFavorite(Favorite favorite) {
        favoriteDao.insert(favorite);
    }

    @Override
    public void deleteHistory(String word, int sourceLang) {
        historyDao.delete(word, sourceLang);
    }

    @Override
    public void deleteFavorite(String word, int sourceLang) {
        favoriteDao.delete(word, sourceLang);
    }

    @Override
    public boolean existHistory(String history) {
        return historyDao.exist(history);
    }

    @Override
    public boolean existFavorite(String favorite, int sourceLang) {
        return favoriteDao.exist(favorite, sourceLang);
    }
}
