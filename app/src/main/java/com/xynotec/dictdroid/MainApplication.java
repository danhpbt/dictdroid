package com.xynotec.dictdroid;

import android.content.Context;

import com.xynotec.common.TTS;
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

    private static Context context;
    public static Context getContext()
    {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        TTS.getInstance(); // init TTS engine
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent component = DaggerAppComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }
}
