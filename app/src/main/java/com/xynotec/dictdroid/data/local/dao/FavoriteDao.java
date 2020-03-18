package com.xynotec.dictdroid.data.local.dao;

import androidx.lifecycle.LiveData;

import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.realm.livemodel.LiveRealmResults;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

public class FavoriteDao {

    Realm realm;
    RealmConfiguration mConfig;

    @Inject
    public FavoriteDao(RealmConfiguration config) {
        mConfig = config;
        realm = Realm.getInstance(mConfig);
    }

    public LiveData<List<Favorite>> get(int sourceLang)
    {
        return new LiveRealmResults<>(realm.where(Favorite.class).equalTo("dictLang", sourceLang)
                .sort("dateTime", Sort.DESCENDING).findAll());
    }

    private RealmResults<Favorite> query(String word, int sourceLang)
    {
        RealmResults<Favorite> histories = realm.where(Favorite.class)
                .equalTo("word", word)
                .equalTo("dictLang", sourceLang).findAll();
        return histories;
    }

    public boolean exist(String word, int sourceLang) {

        return query(word, sourceLang).size() > 0;
    }

    public void insert(Favorite favorite)
    {
        realm.beginTransaction();

        //realm.copyFromRealm(favorite);
        realm.insertOrUpdate(favorite);

        realm.commitTransaction();
    }

    public void delete(String word, int sourceLang)
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Favorite> result = realm.where(Favorite.class)
                        .equalTo("word", word)
                        .equalTo("dictLang", sourceLang).findAll();
                result.deleteAllFromRealm();
            }
        });

//        //Lamda expression
//        realm.executeTransaction(realm1 ->
//        {
//            RealmResults<Favorite> result = realm.where(Favorite.class)
//                    .equalTo("word", word)
//                    .equalTo("dictLang", sourceLang).findAll();
//            result.deleteAllFromRealm();
//        });
    }

}