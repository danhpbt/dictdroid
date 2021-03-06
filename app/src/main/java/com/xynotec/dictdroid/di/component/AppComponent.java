package com.xynotec.dictdroid.di.component;

import android.app.Application;

import com.xynotec.dictdroid.MainApplication;
import com.xynotec.dictdroid.di.module.ActivityBuilder;
import com.xynotec.dictdroid.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBuilder.class, AppModule.class})
public interface AppComponent extends AndroidInjector<MainApplication> {
    void inject(MainApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
