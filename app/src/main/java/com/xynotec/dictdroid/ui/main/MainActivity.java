package com.xynotec.dictdroid.ui.main;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.xynotec.dagger.BaseActivity;
import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.adapters.FixedIconTabsAdapter;
import com.xynotec.dictdroid.control.SearchBar;
import com.xynotec.dictdroid.data.local.prefs.AppPreferencesHelper;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.engine.DictEngine;
import com.xynotec.dictdroid.ui.main.search.SearchFragment;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity<BaseViewModel> implements
        SearchBar.OnSearchBarTextChange{

    final static int SEARCH_FRAGMENT = 0;


    private AppBarConfiguration mAppBarConfiguration;

    @Inject
    DictEngine dictEngine;

    @Inject
    AppPreferencesHelper mAppPreferencesHelper;

    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.searchBar) SearchBar searchBar;

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);

        searchBar.setOnSearchBarTextChange(this);

        setupViewPager(viewPager);

        dictEngine.OpenDict("ende.mdo");
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
}
