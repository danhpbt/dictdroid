package com.xynotec.dictdroid.ui.main.favorite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dagger.BaseFragment;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentFavoriteBinding;
import com.xynotec.dictdroid.ui.main.MainActivity;
import com.xynotec.dictdroid.ui.main.MainViewModel;
import com.xynotec.dictdroid.ui.mean.MeanActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class FavoriteFragment extends BaseFragment<FragmentFavoriteBinding, FavoriteViewModel> implements
        FavoriteFragmentAdapter.HistoryFragmentAdapterListener {

    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.rvFavorite)
    RecyclerView rvFavorite;

    FavoriteFragmentAdapter mFavoriteFragmentAdapter;

    @Inject
    ViewModelProviderFactory factory;
    FavoriteViewModel mFavoriteViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_favorite;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        Context context = getContext();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);

        linearLayoutManager = new LinearLayoutManager(context);

        mFavoriteFragmentAdapter  = new FavoriteFragmentAdapter(mFavoriteViewModel);

        rvFavorite.setLayoutManager(linearLayoutManager);
        rvFavorite.addItemDecoration(dividerItemDecoration);
        rvFavorite.setAdapter(mFavoriteFragmentAdapter);

        mFavoriteFragmentAdapter.setListener(this);

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        mFavoriteFragmentAdapter.loadFavorites();
    }

    @Override
    public void onClickListener(int index) {
        showMean(index);
    }

    void showMean(int index) {

        Favorite favorite = mFavoriteFragmentAdapter.getItem(index);

        MainActivity activity = (MainActivity)getBaseActivity();
        MainViewModel mainViewModel = activity.getViewModel();
        String activityTitle = mainViewModel.getDictLongName().get();

        Intent intent = new Intent(activity, MeanActivity.class);
        intent.putExtra("title", activityTitle);
        intent.putExtra("word", favorite.getWord());
        intent.putExtra("mean", favorite.getMean());
        intent.putExtra("lang", favorite.getDictLang());
        startActivity(intent);
    }
}
