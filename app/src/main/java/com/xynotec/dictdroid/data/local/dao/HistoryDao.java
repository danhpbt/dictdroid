package com.xynotec.dictdroid.data.local.dao;

import androidx.lifecycle.LiveData;

import com.xynotec.dictdroid.data.model.History;
import com.xynotec.realm.livemodel.LiveRealmResults;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class HistoryDao {

    Realm realm;
    RealmConfiguration mConfig;

    @Inject
    public HistoryDao(RealmConfiguration config) {
        mConfig = config;
        realm = Realm.getInstance(mConfig);
    }

    public LiveData<List<History>> getHistories()
    {
        return new LiveRealmResults<>(realm.where(History.class).findAllAsync());
    }

    private RealmResults<History> queryHistory(String word)
    {
        RealmResults<History> histories = realm.where(History.class).equalTo("word", word).findAll();
        return histories;
    }

    public boolean exist(String word) {

        return queryHistory(word).size() > 0;
    }

    public void insertHistory(History history)
    {
        realm.beginTransaction();

        realm.copyFromRealm(history);

        realm.commitTransaction();
    }

}
