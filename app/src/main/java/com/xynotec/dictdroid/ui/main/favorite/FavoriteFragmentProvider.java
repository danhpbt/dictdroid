package com.xynotec.dictdroid.ui.main.favorite;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FavoriteFragmentProvider
{
    @ContributesAndroidInjector(modules = {})
    abstract FavoriteFragment provideFavoriteFragmentFactory();
}
