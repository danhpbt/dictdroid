package com.xynotec.dictdroid.data.local.db;

import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;

import java.util.List;

public interface DbHelper {

    List<History> getHistory();
    List<Favorite> getFavorite();
    void insertHistory(History history);
    void insertFavorite(Favorite favorite);


}
