package com.xynotec.dictdroid.ui.about;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dagger.BaseActivity;
import com.xynotec.dictdroid.MainApplication;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.ActivityAboutBinding;

import javax.inject.Inject;

public class AboutActivity extends BaseActivity<ActivityAboutBinding, AboutViewModel> {

    @Inject
    ViewModelProviderFactory factory;
    private AboutViewModel mAboutViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_about;
    }

    @Override
    public int getBindingVariable() {
        return BR.aboutVM;
    }

    @Override
    public AboutViewModel getViewModel() {
        mAboutViewModel = new ViewModelProvider(this, factory).get(AboutViewModel.class);
        return mAboutViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar)findViewById(R.id.sub_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setTitle(R.string.title_about);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_back);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

    }
}
