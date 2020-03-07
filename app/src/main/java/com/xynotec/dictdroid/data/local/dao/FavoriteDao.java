package com.xynotec.dictdroid.data.local.dao;

import androidx.lifecycle.LiveData;

import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.realm.livemodel.LiveRealmResults;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class FavoriteDao {

    Realm realm;
    RealmConfiguration mConfig;

    @Inject
    public FavoriteDao(RealmConfiguration config) {
        mConfig = config;
        realm = Realm.getInstance(mConfig);
    }

    public LiveData<List<Favorite>> getFavorites()
    {
        return new LiveRealmResults<>(realm.where(Favorite.class).findAllAsync());
    }

    private RealmResults<Favorite> queryFavorite(String word)
    {
        RealmResults<Favorite> histories = realm.where(Favorite.class).equalTo("word", word).findAll();
        return histories;
    }

    public boolean exist(String word) {

        return queryFavorite(word).size() > 0;
    }

    public void insertFavorite(Favorite favorite)
    {
        realm.beginTransaction();

        realm.copyFromRealm(favorite);

        realm.commitTransaction();
    }

}