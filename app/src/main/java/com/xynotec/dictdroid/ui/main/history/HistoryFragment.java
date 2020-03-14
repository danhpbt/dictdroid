package com.xynotec.dictdroid.ui.main.history;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dagger.BaseFragment;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.control.MeanView;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentHistoryBinding;

import javax.inject.Inject;

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding, HistoryViewModel> implements
        HistoryFragmentAdapter.HistoryFragmentAdapterListener {

    LinearLayoutManager linearLayoutManager;
    RecyclerView rvHistory;

    HistoryFragmentAdapter mHistoryFragmentAdapter;

    @Inject
    ViewModelProviderFactory factory;
    HistoryViewModel mHistoryViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_history;
    }

    @Override
    public int getBindingVariable() {
        return BR.historyVM;
    }

    @Override
    public HistoryViewModel getViewModel() {
        mHistoryViewModel = new ViewModelProvider(this, factory).get(HistoryViewModel.class);
        return mHistoryViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        Context context = getContext();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);

        linearLayoutManager = new LinearLayoutManager(context);

        mHistoryFragmentAdapter  = new HistoryFragmentAdapter(mHistoryViewModel);

        rvHistory = view.findViewById(R.id.rvHistory);
        rvHistory.setLayoutManager(linearLayoutManager);
        rvHistory.addItemDecoration(dividerItemDecoration);
        rvHistory.setAdapter(mHistoryFragmentAdapter);

        mHistoryFragmentAdapter.setListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClickListener(int index) {
//        showMean(index);
    }

}
