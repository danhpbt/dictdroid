package com.xynotec.dictdroid.ui.main.history;

import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dagger.BaseFragment;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentFavoriteBinding;
import com.xynotec.dictdroid.ende.databinding.FragmentHistoryBinding;

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding, HistoryViewModel> {
    HistoryViewModel mHistoryViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_history;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public HistoryViewModel getViewModel() {
        mHistoryViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        return mHistoryViewModel;
    }
}
