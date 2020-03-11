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
    public LiveData<List<History>> getHistories() {
        return historyDao.getHistories();
    }

    @Override
    public LiveData<List<Favorite>> getFavorites() {
        return favoriteDao.getFavorites();
    }

    @Override
    public void insertHistory(History history) {
        historyDao.insertHistory(history);
    }

    @Override
    public void insertFavorite(Favorite favorite) {
        favoriteDao.insertFavorite(favorite);
    }

    @Override
    public boolean existHistory(String history) {
        return historyDao.exist(history);
    }

    @Override
    public boolean existFavorite(String favorite) {
        return favoriteDao.exist(favorite);
    }
}
