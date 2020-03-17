package com.xynotec.dictdroid.ui.main.search;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.data.model.History;
import com.xynotec.dictdroid.utils.HtmlConverter;

public class SearchViewModel extends BaseViewModel {

    final static int SEARCH_VIEW = 0;
    final static int MEAN_VIEW = 1;

    private static final String TAG = "SearchViewModel";

    final ObservableField<String> mWord = new ObservableField<>();
    final ObservableField<String> mMean = new ObservableField<>();

    final ObservableInt mWordIndex = new ObservableInt();
    final ObservableInt mViewDisplay = new ObservableInt();

    public SearchViewModel(DataManager dataManager) {
        super(dataManager);

        mWordIndex.set(0);
        mViewDisplay.set(SEARCH_VIEW);
    }

    public void openDict(String path)
    {
        getDataManager().openDict(path);
    }

    public int numWord()
    {
        return getDataManager().numWordInDict();
    }

    public String getDictWord(int index)
    {
        return getDataManager().getDictWord(index);
    }

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

        //Reformat for webview
        mean = HtmlConverter.String_htmlEncode(mean, getDataManager().getDictSource());
        float zoomScale = getDataManager().getZoomScale()/100.0f;
        mean = HtmlConverter.update4ViewPort(mean, zoomScale);

        mWord.set(word);
        mMean.set(mean);
    }

    private void insertUpdateHistory(String word, String mean, int dictSource)
    {
        History history = new History();
        history.setWordMean(word, mean, dictSource);
        getDataManager().insertHistory(history);
    }

//    public void setWordMean(String word, String mean)
//    {
//        mWord.set(word);
//        mMean.set(mean);
//    }

    public ObservableField<String> getWord()
    {
        return mWord;
    }

    public ObservableField<String> getMean()
    {
        return mMean;
    }

    public void onSpeakerClick()
    {
        Log.d(TAG, "onSpeakerClick: ");
    }
}
