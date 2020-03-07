package com.xynotec.dictdroid.ui.main;

import com.xynotec.dictdroid.ui.main.search.SearchFragmentAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    SearchFragmentAdapter provideSearchFragmentAdapter(MainActivity mainActivity) {
        return new SearchFragmentAdapter(mainActivity.dictEngine);
    }
}
