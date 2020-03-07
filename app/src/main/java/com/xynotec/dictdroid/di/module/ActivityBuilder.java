package com.xynotec.dictdroid.di.module;

import com.xynotec.dictdroid.ui.main.MainActivity;
import com.xynotec.dictdroid.ui.main.MainActivityModule;
import com.xynotec.dictdroid.ui.main.favorite.FavoriteFragmentProvider;
import com.xynotec.dictdroid.ui.main.history.HistoryFragmentProvider;
import com.xynotec.dictdroid.ui.main.search.SearchFragmentProvider;
import com.xynotec.dictdroid.ui.main.translate.TranslateFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            SearchFragmentProvider.class,
            HistoryFragmentProvider.class,
            FavoriteFragmentProvider.class,
            TranslateFragmentProvider.class
    })
    abstract MainActivity bindMainActivity();
}
