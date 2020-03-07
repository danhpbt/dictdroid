package com.xynotec.dictdroid.ui.main.history;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HistoryFragmentProvider
{
    @ContributesAndroidInjector(modules = {})
    abstract HistoryFragment provideHistoryFragmentFactory();
}
