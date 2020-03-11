package com.xynotec.dictdroid;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.ui.main.MainViewModel;
import com.xynotec.dictdroid.ui.main.favorite.FavoriteViewModel;
import com.xynotec.dictdroid.ui.main.history.HistoryViewModel;
import com.xynotec.dictdroid.ui.main.search.SearchViewModel;
import com.xynotec.dictdroid.ui.main.translate.TranslateViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel();
        } else if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            //noinspection unchecked
            return (T) new SearchViewModel();
        } else if (modelClass.isAssignableFrom(HistoryViewModel.class)) {
            //noinspection unchecked
            return (T) new HistoryViewModel();
        } else if (modelClass.isAssignableFrom(FavoriteViewModel.class)) {
            //noinspection unchecked
            return (T) new FavoriteViewModel();
        }
        else if (modelClass.isAssignableFrom(TranslateViewModel.class)) {
            //noinspection unchecked
            return (T) new TranslateViewModel();
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

}
