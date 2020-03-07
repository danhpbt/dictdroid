package com.xynotec.dictdroid.di.module;

import android.app.Application;
import android.content.Context;

import com.xynotec.dictdroid.data.local.prefs.AppPreferencesHelper;
import com.xynotec.dictdroid.data.local.prefs.PreferencesHelper;
import com.xynotec.dictdroid.engine.DictEngine;
import com.xynotec.dictdroid.engine.DictEngineInternal;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DictEngine provideDictEngine(Context context) {
        return new DictEngineInternal(context);
    }

    @Singleton
    @Provides
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper){
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    RealmConfiguration provideRealmConfiguration(Context context) {
        Realm.init(context);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfig);
        return realmConfig;
    }
}
