package com.xynotec.dagger;

import androidx.lifecycle.ViewModel;

import com.xynotec.dictdroid.data.DataManager;

import javax.inject.Inject;

public abstract class BaseViewModel extends ViewModel {

    private final DataManager mDataManager;

    public BaseViewModel(DataManager dataManager)
    {
        this.mDataManager = dataManager;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }
}
