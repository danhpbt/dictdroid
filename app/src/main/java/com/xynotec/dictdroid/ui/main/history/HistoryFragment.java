package com.xynotec.dictdroid.ui.main.history;

import android.content.Context;
import android.content.Intent;
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
import com.xynotec.dictdroid.data.model.History;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentHistoryBinding;
import com.xynotec.dictdroid.ui.main.MainActivity;
import com.xynotec.dictdroid.ui.main.MainViewModel;
import com.xynotec.dictdroid.ui.mean.MeanActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding, HistoryViewModel> implements
        HistoryFragmentAdapter.HistoryFragmentAdapterListener {

    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.rvHistory)
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

        rvHistory.setLayoutManager(linearLayoutManager);
        rvHistory.addItemDecoration(dividerItemDecoration);
        rvHistory.setAdapter(mHistoryFragmentAdapter);

        mHistoryFragmentAdapter.setListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mHistoryFragmentAdapter.loadHistories();
    }

    @Override
    public void onClickListener(int index) {
        showMean(index);
    }

    void showMean(int index) {

        History history = mHistoryFragmentAdapter.getItem(index);

        MainActivity activity = (MainActivity)getBaseActivity();
        MainViewModel mainViewModel = activity.getViewModel();
        String activityTitle = mainViewModel.getDictLongName().get();

        Intent intent = new Intent(activity, MeanActivity.class);
        intent.putExtra("title", activityTitle);
        intent.putExtra("word", history.getWord());
        intent.putExtra("mean", history.getMean());
        intent.putExtra("lang", history.getDictLang());
        startActivity(intent);
    }

}
