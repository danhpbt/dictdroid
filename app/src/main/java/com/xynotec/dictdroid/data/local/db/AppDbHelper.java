package com.xynotec.dictdroid.data.local.db;

import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;

import java.util.List;

import javax.inject.Inject;

public class AppDbHelper implements DbHelper {
    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public List<History> getHistory() {
        return null;
    }

    @Override
    public List<Favorite> getFavorite() {
        return null;
    }

    @Override
    public void insertHistory(History history) {

    }

    @Override
    public void insertFavorite(Favorite favorite) {

    }
}
