package com.xynotec.dictdroid.ui.main.translate;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TranslateFragmentProvider
{
    @ContributesAndroidInjector(modules = {})
    abstract TranslateFragment provideTranslateFragmentFactory();
}
