package com.xynotec.dictdroid.ui.main.favorite;

import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dagger.BaseFragment;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentFavoriteBinding;

import javax.inject.Inject;

public class FavoriteFragment extends BaseFragment<FragmentFavoriteBinding, FavoriteViewModel> {

    @Inject
    ViewModelProviderFactory factory;
    FavoriteViewModel mFavoriteViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_search;
    }

    @Override
    public int getBindingVariable() {
        return BR.favoriteVM;
    }

    @Override
    public FavoriteViewModel getViewModel() {
        mFavoriteViewModel = new ViewModelProvider(this, factory).get(FavoriteViewModel.class);
        return mFavoriteViewModel;
    }
}
