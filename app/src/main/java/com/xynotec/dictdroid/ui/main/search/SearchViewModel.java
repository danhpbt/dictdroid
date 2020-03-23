package com.xynotec.dictdroid.ui.main.search;

import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;
import com.xynotec.dictdroid.engine.LangConst;
import com.xynotec.dictdroid.ui.base.viewmodel.BaseMeanViewModel;
import com.xynotec.dictdroid.utils.HtmlConverter;

import java.util.Locale;

public class SearchViewModel extends BaseMeanViewModel {

    final static int SEARCH_VIEW = 0;
    final static int MEAN_VIEW = 1;

    private static final String TAG = "SearchViewModel";

    final ObservableInt mWordIndex = new ObservableInt();
    final ObservableInt mViewDisplay = new ObservableInt();

    public SearchViewModel(DataManager dataManager) {
        super(dataManager);

        mWordIndex.set(0);
        mViewDisplay.set(SEARCH_VIEW);

    }

//    public void openDict(String path)
//    {
//        getDataManager().openDict(path);
//    }

    public int numWord()
    {
        return getDataManager().numWordInDict();
    }

//    public String getDictWord(int index)
//    {
//        return getDataManager().getDictWord(index);
//    }

    public void onEditSearch(String word)
    {
        mViewDisplay.set(SEARCH_VIEW);

        int index = getDataManager().onDictSearch(word);
        mWordIndex.set(index);
    }

    public void onSubmitSearch(String word)
    {
        mViewDisplay.set(SEARCH_VIEW);

        int posWord = getDataManager().onDictSearch(word);
        String wordFind = getDataManager().getDictWord(posWord);
        if (wordFind.compareToIgnoreCase(word) == 0)
            showMean(posWord);
    }

    public ObservableInt getWordIndex()
    {
        return mWordIndex;
    }

    public ObservableInt getViewDisplay()
    {
        return mViewDisplay;
    }

    public void showMean(int index)
    {
        mViewDisplay.set(MEAN_VIEW);

        String word = getDataManager().getDictWord(index);
        String mean = getDataManager().getMeanWord(index);

        insertUpdateHistory(word, mean, getDataManager().getSourceLang());

        setMean(word, mean);
    }

    public void updateZoomScale()
    {
        if (mViewDisplay.get() == MEAN_VIEW)
            setZoomScale(getDataManager().getZoomScale());
    }

    private void insertUpdateHistory(String word, String mean, int dictSource)
    {
        History history = new History();
        history.setWordMean(word, mean, dictSource);
        getDataManager().insertHistory(history);
    }

}
