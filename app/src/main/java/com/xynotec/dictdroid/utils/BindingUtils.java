package com.xynotec.dictdroid.utils;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dagger.BaseActivity;
import com.xynotec.dictdroid.control.MeanView;
import com.xynotec.dictdroid.control.SearchBar;
import com.xynotec.utils.DeviceUtils;

public final class BindingUtils {

    @BindingAdapter({"mvWord", "mvMean"})
    public static void setMeanView(MeanView meanView, String word, String mean) {
        //hide keyboard before display
        Activity activity = (Activity)meanView.getContext();
        DeviceUtils.hideEmulatorKeyboard(activity);

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
        if (linearLayoutManager != null)
            linearLayoutManager.scrollToPositionWithOffset(position,0);
    }

    @BindingAdapter("srcImageResId")
    public static void setImageDrawable(ImageView view, @DrawableRes int drawableId) {
        if (drawableId != 0) {
            view.setImageResource(drawableId);
        }
    }

    @BindingAdapter("searchBarHintText")
    public static void setImageDrawable(SearchBar searchBar, String hint) {
        searchBar.setHintText(hint);
    }
}
