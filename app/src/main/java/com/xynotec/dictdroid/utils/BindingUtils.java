package com.xynotec.dictdroid.utils;

import android.widget.ViewFlipper;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dictdroid.control.MeanView;

public final class BindingUtils {

    @BindingAdapter({"mvWord", "mvMean"})
    public static void setMeanView(MeanView meanView, String word, String mean) {
        meanView.setWordMean(word, mean);
    }

    @BindingAdapter("flipperIndex")
    public static void setViewFlipperIndex(ViewFlipper viewFlipper, int index) {
        viewFlipper.setDisplayedChild(index);
    }

    @BindingAdapter("rvScrollToPosition")
    public static void scrollViewPagerToPosition(RecyclerView recyclerView, int position)
    {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
        linearLayoutManager.scrollToPositionWithOffset(position,0);
    }
}
