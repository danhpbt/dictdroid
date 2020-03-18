package com.xynotec.dictdroid.ui.mean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dagger.BaseActivity;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.control.MeanView;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.ActivityMeanBinding;

import javax.inject.Inject;

import butterknife.BindView;

public class MeanActivity extends BaseActivity<ActivityMeanBinding, MeanViewModel> implements
            MeanView.OnMeanviewListener {

    @BindView(R.id.sub_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.meanView)
    MeanView meanView;

    @Inject
    ViewModelProviderFactory factory;
    private MeanViewModel mMeanViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_mean;
    }

    @Override
    public int getBindingVariable() {
        return BR.meanVM;
    }

    @Override
    public MeanViewModel getViewModel() {
        mMeanViewModel = new ViewModelProvider(this, factory).get(MeanViewModel.class);
        return mMeanViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        meanView.setListener(this);

        Bundle bundle = getIntent().getExtras();

        String title = bundle.getString("title");
        String word = bundle.getString("word");
        String mean = bundle.getString("mean");
        int lang = bundle.getInt("lang");

        mMeanViewModel.setMean(word, mean);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);

            getSupportActionBar().setTitle(title);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_close);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }


    }

    @Override
    public void onClickFavorite() {
        mMeanViewModel.toggleFavorite();
    }
}
