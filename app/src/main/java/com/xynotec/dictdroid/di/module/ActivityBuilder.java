package com.xynotec.dictdroid.di.module;

import com.xynotec.dictdroid.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {
            })
    abstract MainActivity bindMainActivity();
}
