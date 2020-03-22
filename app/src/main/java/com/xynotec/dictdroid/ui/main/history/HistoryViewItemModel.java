package com.xynotec.dictdroid.ui.main.history;

import android.content.Context;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableBoolean;

import com.xynotec.dictdroid.MainApplication;
import com.xynotec.dictdroid.engine.LangConst;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryViewItemModel {

    final int mIndex;
    final String mWord;
    final int mDictLang;
    final Date mDateTime;
    ObservableBoolean mSelected = new ObservableBoolean(false);

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

    public void setSelected(boolean bSelected)
    {
        this.mSelected.set(bSelected);
    }

    public ObservableBoolean getSelected()
    {
        return this.mSelected;
    }

    public void onItemClick()
    {
        mHistoryViewItemModelListener.onItemClick(mIndex);
    }

    public boolean onItemLongClick(View view)
    {
        mHistoryViewItemModelListener.onItemLongClick(mIndex);
        return true;
    }

    interface HistoryViewItemModelListener{
        void onItemClick(int index);
        void onItemLongClick(int index);
    }
}
