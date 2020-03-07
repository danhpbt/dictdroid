package com.xynotec.dictdroid.ui.main.search;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SearchFragmentProvider
{
    @ContributesAndroidInjector(modules = {})
    abstract SearchFragment provideSearchFragmentFactory();
}
