package com.xynotec.dictdroid.ui.main.translate;

import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dagger.BaseFragment;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentFavoriteBinding;
import com.xynotec.dictdroid.ende.databinding.FragmentTranslateBinding;
import com.xynotec.dictdroid.ui.main.favorite.FavoriteViewModel;

import javax.inject.Inject;

public class TranslateFragment extends BaseFragment<FragmentTranslateBinding, TranslateViewModel> {

    @Inject
    ViewModelProviderFactory factory;
    TranslateViewModel mTranslateViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_translate;
    }

    @Override
    public int getBindingVariable() {
        return BR.translateVM;
    }

    @Override
    public TranslateViewModel getViewModel() {
        mTranslateViewModel = new ViewModelProvider(this, factory).get(TranslateViewModel.class);
        return mTranslateViewModel;
    }
}
