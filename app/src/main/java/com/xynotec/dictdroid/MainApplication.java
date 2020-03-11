package com.xynotec.dictdroid;

import com.xynotec.dictdroid.di.component.AppComponent;
import com.xynotec.dictdroid.di.component.DaggerAppComponent;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MainApplication extends DaggerApplication {

    static
    {
        System.loadLibrary("dictdroid");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent component = DaggerAppComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }
}
