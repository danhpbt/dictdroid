package com.xynotec.dictdroid.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ui.main.favorite.FavoriteFragment;
import com.xynotec.dictdroid.ui.main.history.HistoryFragment;
import com.xynotec.dictdroid.ui.main.search.SearchFragment;
import com.xynotec.dictdroid.ui.main.translate.TranslateFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danh Phan on 10/19/2016.
 */

public class FixedIconTabsAdapter extends FragmentPagerAdapter {

    private int[] tabIcons = {
            R.drawable.ic_tab_search,
            R.drawable.ic_tab_history,
            R.drawable.ic_tab_favorite,
            R.drawable.ic_tab_translate
    };
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public FixedIconTabsAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mFragmentList.add(new SearchFragment());
        mFragmentList.add(new HistoryFragment());
        mFragmentList.add(new FavoriteFragment());
        mFragmentList.add(new TranslateFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return tabIcons.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
