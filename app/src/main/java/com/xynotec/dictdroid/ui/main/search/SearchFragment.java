package com.xynotec.dictdroid.ui.main.search;

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
import com.xynotec.dictdroid.ende.databinding.FragmentSearchBinding;

import javax.inject.Inject;

public class SearchFragment extends BaseFragment<FragmentSearchBinding, SearchViewModel> implements
        SearchFragmentAdapter.SearchFragmentAdapterListener {

    LinearLayoutManager linearLayoutManager;
    ViewFlipper viewFlipper;
    RecyclerView rvWord;
    MeanView meanView;

    SearchFragmentAdapter mSearchFragmentAdapter;

    @Inject
    ViewModelProviderFactory factory;
    SearchViewModel mSearchViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_search;
    }

    @Override
    public int getBindingVariable() {
        return BR.searchVM;
    }

    @Override
    public SearchViewModel getViewModel() {
        mSearchViewModel = new ViewModelProvider(this, factory).get(SearchViewModel.class);
        return mSearchViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        Context context = getContext();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);

        viewFlipper = view.findViewById(R.id.viewFlipper);

        linearLayoutManager = new LinearLayoutManager(context);

        mSearchFragmentAdapter = new SearchFragmentAdapter(mSearchViewModel);

        rvWord = view.findViewById(R.id.rvWord);
        rvWord.setLayoutManager(linearLayoutManager);
        rvWord.addItemDecoration(dividerItemDecoration);
        rvWord.setAdapter(mSearchFragmentAdapter);

        mSearchFragmentAdapter.setListener(this);

        meanView = view.findViewById(R.id.meanView);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClickListener(int index) {
        showMean(index);
    }

    public void onEditSearch(String word) {
        mSearchViewModel.onEditSearch(word);
    }

    public void onSubmitSearch(String word) {
        mSearchViewModel.onSubmitSearch(word);
    }

    public void onSwapDict()
    {
        mSearchFragmentAdapter.notifyDataSetChanged();
    }

    void showMean(int index) {
        mSearchViewModel.showMean(index);
    }


}
