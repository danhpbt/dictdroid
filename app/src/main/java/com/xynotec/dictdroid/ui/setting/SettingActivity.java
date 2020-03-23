package com.xynotec.dictdroid.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dagger.BaseActivity;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.ActivitySettingsBinding;

import javax.inject.Inject;

public class SettingActivity extends BaseActivity<ActivitySettingsBinding, SettingViewModel> {

    @Inject
    ViewModelProviderFactory factory;
    private SettingViewModel mSettingViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_settings;
    }

    @Override
    public int getBindingVariable() {
        return BR.settingVM;
    }

    @Override
    public SettingViewModel getViewModel() {
        mSettingViewModel = new ViewModelProvider(this, factory).get(SettingViewModel.class);
        return mSettingViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar)findViewById(R.id.sub_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setTitle(R.string.title_settings);
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
