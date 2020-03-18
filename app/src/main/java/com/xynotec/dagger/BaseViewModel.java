package com.xynotec.dagger;

import androidx.lifecycle.ViewModel;

import com.xynotec.dictdroid.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    private final DataManager mDataManager;
    private CompositeDisposable mCompositeDisposable;//for Observe network

    public BaseViewModel(DataManager dataManager)
    {
        this.mDataManager = dataManager;
        mCompositeDisposable = new CompositeDisposable();
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }
}
