package com.xynotec.dictdroid.ui.main.search;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class SearchViewItemModel {

    final ObservableInt mIndex;
    final ObservableField<String> mWord;
    final SearchViewItemModelListener mSearchViewItemModelListener;

    public SearchViewItemModel(int index, String word, SearchViewItemModelListener searchViewItemModelListener) {
        this.mIndex = new ObservableInt(index);
        this.mWord = new ObservableField<>(word);
        this.mSearchViewItemModelListener = searchViewItemModelListener;
    }

    public String getWord()
    {
        return mWord.get();
    }

    public void onItemClick()
    {
        mSearchViewItemModelListener.onItemClick(mIndex.get());
    }

    public interface SearchViewItemModelListener{
        void onItemClick(int index);
    }


}
