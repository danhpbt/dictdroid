package com.xynotec.dictdroid;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.ui.login.LoginViewModel;
import com.xynotec.dictdroid.ui.main.MainViewModel;
import com.xynotec.dictdroid.ui.main.favorite.FavoriteViewModel;
import com.xynotec.dictdroid.ui.main.history.HistoryViewModel;
import com.xynotec.dictdroid.ui.main.search.SearchViewModel;
import com.xynotec.dictdroid.ui.main.translate.TranslateViewModel;
import com.xynotec.dictdroid.ui.mean.MeanViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory implements ViewModelProvider.Factory {

    private final DataManager mDataManager;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(mDataManager);
        }
        else if (modelClass.isAssignableFrom(MeanViewModel.class)) {
            return (T) new MeanViewModel(mDataManager);
        }
        else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(mDataManager);
        }
        else if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            return (T) new SearchViewModel(mDataManager);
        }
        else if (modelClass.isAssignableFrom(HistoryViewModel.class)) {
            return (T) new HistoryViewModel(mDataManager);
        }
        else if (modelClass.isAssignableFrom(FavoriteViewModel.class)) {
            return (T) new FavoriteViewModel(mDataManager);
        }
        else if (modelClass.isAssignableFrom(TranslateViewModel.class)) {
            return (T) new TranslateViewModel(mDataManager);
        }

        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
