package com.xynotec.dictdroid.ui.main.favorite;

import android.content.Context;

import com.xynotec.dictdroid.MainApplication;
import com.xynotec.dictdroid.engine.LangConst;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FavoriteViewItemModel {
    final int mIndex;
    final String mWord;
    final int mDictLang;
    final Date mDateTime;

    final FavoriteViewItemModelListener mFavoriteViewItemModelListener;

    public FavoriteViewItemModel(int index, String word, int dictLand, Date dateTime, FavoriteViewItemModelListener historyViewItemModelListener) {
        this.mIndex = index;
        this.mWord = word;
        this.mDictLang = dictLand;
        this.mDateTime = dateTime;
        this.mFavoriteViewItemModelListener = historyViewItemModelListener;
    }

    public String getWord()
    {
        return mWord;
    }

    public String getDateTime()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a MMM dd, yyyy");
        String time = dateFormat.format(mDateTime);
        return time;
    }

    public int getFlagResource()
    {
        String symbol = LangConst.langToLocale.get(Integer.valueOf(mDictLang));
        String flagFrom = String.format("flag_%s", symbol);

        Context context = MainApplication.getContext();
        int resId = context.getResources().getIdentifier(flagFrom, "drawable", context.getPackageName());
        return resId;
    }

    public void onItemClick()
    {
        mFavoriteViewItemModelListener.onItemClick(mIndex);
    }

    interface FavoriteViewItemModelListener{
        void onItemClick(int index);
    }
}
