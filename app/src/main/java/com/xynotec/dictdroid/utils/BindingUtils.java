package com.xynotec.dictdroid.utils;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.xynotec.dagger.BaseActivity;
import com.xynotec.dictdroid.control.MeanView;
import com.xynotec.dictdroid.control.SearchBar;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.utils.DeviceUtils;

import java.util.Locale;

public final class BindingUtils {

    private static final String MIMETYPE = "text/html";
    private static final String ENCODING = "UTF-8";

    @BindingAdapter({"dataHtml"})
    public static void setWebView(WebView webView, String html) {
        webView.loadDataWithBaseURL(null, html,
                MIMETYPE, ENCODING, "about:blank");
    }


    @BindingAdapter({"mvWord", "mvMean", "mvInFavorite", "mvLocale", "mvZoomScale"})
    public static void setMeanView(MeanView meanView, String word, String mean, boolean bInFav, Locale locale, int zoomScale) {
        //hide keyboard before display
        Activity activity = (Activity)meanView.getContext();
        DeviceUtils.hideEmulatorKeyboard(activity);

        meanView.setWordMean(word, mean, bInFav, locale, zoomScale);
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
    public static void setSearchBarHintText(SearchBar searchBar, String hint) {
        searchBar.setHintText(hint);
    }

    @BindingAdapter("editTextHint")
    public static void setSearchBarHintText(EditText editText, String hint) {
        if ((editText != null) && (editText.length() == 0))
            editText.setHint(hint);
    }

    @BindingAdapter("navSourceFlag")
    public static void setNavigationSourceFlag(NavigationView navigationView, @DrawableRes int drawableId) {
        View headerLayout = navigationView.getHeaderView(0); // 0-index header
        ImageView imageView = headerLayout.findViewById(R.id.imgFrom);
        imageView.setImageResource(drawableId);
    }

    @BindingAdapter("navDestinationFlag")
    public static void setNavigationDestinationFlag(NavigationView navigationView, @DrawableRes int drawableId) {
        View headerLayout = navigationView.getHeaderView(0); // 0-index header
        ImageView imageView = headerLayout.findViewById(R.id.imgTo);
        imageView.setImageResource(drawableId);
    }

    @BindingAdapter("navHeaderText")
    public static void setNavigationHeaderText(NavigationView navigationView, String string) {
        View headerLayout = navigationView.getHeaderView(0); // 0-index header
        TextView textView = headerLayout.findViewById(R.id.tv_dict_name);
        textView.setText(string);
    }



}
