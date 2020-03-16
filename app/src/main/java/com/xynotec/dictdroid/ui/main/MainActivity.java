package com.xynotec.dictdroid.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.xynotec.dagger.BaseActivity;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.adapters.FixedIconTabsAdapter;
import com.xynotec.dictdroid.control.SearchBar;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.ActivityMainBinding;
import com.xynotec.dictdroid.engine.LangConst;
import com.xynotec.dictdroid.ui.main.search.SearchFragment;
import com.xynotec.utils.CommonUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements
        SearchBar.OnSearchBarTextChange{

    final int REQ_CODE_SPEECH_INPUT = 9879;

    final static int SEARCH_FRAGMENT = 0;


    private AppBarConfiguration mAppBarConfiguration;


    @Inject
    ViewModelProviderFactory factory;
    private MainViewModel mMainViewModel;
    ActivityMainBinding mActivityMainBinding;

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.viewpager) ViewPager viewPager;
    //@BindView(R.id.searchBar) SearchBar searchBar;

    DrawerLayout drawer;

    ImageView swapIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);

        swapIcon = (ImageView) findViewById(R.id.btn_swap);
        swapIcon.setOnClickListener(swapClickListener);
        //searchBar.setOnSearchBarTextChange(this);

        mMainViewModel.openDict();

        setupViewPager(viewPager);
    }

    NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            menuItem -> {

                int id = menuItem.getItemId();

                if (id == R.id.nav_quick_search) {
                    //doQuickSearch();

                } else if (id == R.id.nav_rate) {
                    //doRateApp();

                } else if (id == R.id.nav_share) {
                    //doShareApp();

                } else if (id == R.id.nav_more) {
                    //doMoreApps();

                } else if (id == R.id.nav_remove_ads) {
                    //doRemoveAds();

                } else if (id == R.id.nav_setting) {
                    //doSettings();

                } else if (id == R.id.nav_about) {
                    //doAbout();

                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            };


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);
        return mMainViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.mainVM;
    }

    @Override
    public void onTextChange(String text) {
        tabLayout.getTabAt(SEARCH_FRAGMENT).select();
        SearchFragment searchFragment = (SearchFragment)getFragment(SEARCH_FRAGMENT);
        searchFragment.OnEditSearch(text);
    }

    @Override
    public void onTextSubmit(String text) {
        text = text.trim();

        tabLayout.getTabAt(SEARCH_FRAGMENT).select();
        SearchFragment searchFragment = (SearchFragment)getFragment(SEARCH_FRAGMENT);
        searchFragment.OnSubmitSearch(text);
    }

    @Override
    public void onGoogleVoice() {
        promptSpeechInput();
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        int sourceLang = mMainViewModel.getDataManager().getSourceLang();
        String locale = LangConst.getStringLocale(sourceLang); //update Oct 11, 2016
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, locale);

        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
        try
        {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        }
        catch (Exception a)
        {
            CommonUtils.showErrorDlg(this, a.getMessage());

            //hide not permit voice regconition when error
            //searchBar.hideVoiceRecognition();
        }
    }

    void doSwapDict()
    {
        mMainViewModel.swapDict();
        //Save history, favorite before swapping
//        DictDbHelper.getInstance().SaveHistoryDb();
//        DictDbHelper.getInstance().SaveFavoriteDb();
//
//        GlobalData.bSwapDict = !GlobalData.bSwapDict;
//        GlobalData.setSwapDict(this);
//        DictdroidUtil.InitDictionary(this);
//
//        updateAllView();
    }

    private Fragment getFragment(int index)
    {
        FixedIconTabsAdapter adapter = (FixedIconTabsAdapter)viewPager.getAdapter();
        return adapter.getItem(index);
    }

    private void setupViewPager(ViewPager viewPager) {
        FixedIconTabsAdapter adapter = new FixedIconTabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        final int TABS_COUNT = 4;
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_tab_search);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab_history);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_tab_favorite);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_tab_translate);

        //init select state color
        for(int i = 0; i < TABS_COUNT; i++)
            if (i != 0)
                tabLayout.getTabAt(i).getIcon().setAlpha(128);
            else
                tabLayout.getTabAt(i).getIcon().setAlpha(255);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i < TABS_COUNT; i++)
                    if (i != position)
                        tabLayout.getTabAt(i).getIcon().setAlpha(128);
                    else
                        tabLayout.getTabAt(i).getIcon().setAlpha(255);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String query = result.get(0);
                    //searchBar.setText(query, true);
                }
                break;
        }
    }

    View.OnClickListener swapClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            doSwapDict();
        }
    };
}
