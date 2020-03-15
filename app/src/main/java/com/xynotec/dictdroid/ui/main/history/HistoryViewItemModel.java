package com.xynotec.dictdroid.ui.main.history;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.xynotec.dictdroid.MainApplication;
import com.xynotec.dictdroid.engine.LangConst;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryViewItemModel {

    final int mIndex;
    final String mWord;
    final int mDictLang;
    final Date mDateTime;

    final HistoryViewItemModelListener mHistoryViewItemModelListener;

    public HistoryViewItemModel(int index, String word, int dictLand, Date dateTime, HistoryViewItemModelListener historyViewItemModelListener) {
        this.mIndex = index;
        this.mWord = word;
        this.mDictLang = dictLand;
        this.mDateTime = dateTime;
        this.mHistoryViewItemModelListener = historyViewItemModelListener;
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
        String symbol = LangConst.getSymbol(mDictLang);
        String flagFrom = String.format("flag_%s", symbol);

        Context context = MainApplication.getContext();
        int resId = context.getResources().getIdentifier(flagFrom, "drawable", context.getPackageName());
        return resId;
    }

    public void onItemClick()
    {
        mHistoryViewItemModelListener.onItemClick(mIndex);
    }

    interface HistoryViewItemModelListener{
        void onItemClick(int index);
    }
}
