package com.xynotec.dictdroid.di.module;

import com.xynotec.dictdroid.ui.about.AboutActivity;
import com.xynotec.dictdroid.ui.login.LoginActivity;
import com.xynotec.dictdroid.ui.main.MainActivity;
import com.xynotec.dictdroid.ui.main.MainActivityModule;
import com.xynotec.dictdroid.ui.main.favorite.FavoriteFragmentProvider;
import com.xynotec.dictdroid.ui.main.history.HistoryFragmentProvider;
import com.xynotec.dictdroid.ui.main.search.SearchFragmentProvider;
import com.xynotec.dictdroid.ui.main.translate.TranslateFragmentProvider;
import com.xynotec.dictdroid.ui.mean.MeanActivity;
import com.xynotec.dictdroid.ui.setting.SettingActivity;

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

    @ContributesAndroidInjector(modules = {})
    abstract MeanActivity bindMeanActivity();

    @ContributesAndroidInjector(modules = {})
    abstract SettingActivity bindSettingActivity();

    @ContributesAndroidInjector(modules = {})
    abstract AboutActivity bindAboutActivity();

    @ContributesAndroidInjector(modules = {})
    abstract LoginActivity bindLoginActivity();
}
