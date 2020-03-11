package com.xynotec.dictdroid.ui.main.translate;

import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dagger.BaseFragment;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentFavoriteBinding;
import com.xynotec.dictdroid.ende.databinding.FragmentTranslateBinding;
import com.xynotec.dictdroid.ui.main.favorite.FavoriteViewModel;

public class TranslateFragment extends BaseFragment<FragmentTranslateBinding, TranslateViewModel> {
    TranslateViewModel mTranslateViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_translate;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public TranslateViewModel getViewModel() {
        mTranslateViewModel = new ViewModelProvider(this).get(TranslateViewModel.class);
        return mTranslateViewModel;
    }
}
