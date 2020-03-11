package com.xynotec.dictdroid.utils;

import android.widget.ViewFlipper;

import androidx.databinding.BindingAdapter;

import com.xynotec.dictdroid.control.MeanView;

public final class BindingUtils {

    @BindingAdapter({"setMeanView"})
    public static void setMeanView(MeanView meanView, String word, String mean) {
        meanView.setWordMean(word, mean);
    }

    //@BindingAdapter({"flipperIndex"})
    @BindingAdapter("flipperIndex")
    public static void setViewFlipperIndex(ViewFlipper viewFlipper, int index) {
        viewFlipper.setDisplayedChild(index);
    }
}
