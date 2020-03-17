package com.xynotec.dictdroid.ui.mean;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.utils.HtmlConverter;

public class MeanViewModel extends BaseViewModel {

    final ObservableField<String> mWord = new ObservableField<>();
    final ObservableField<String> mMean = new ObservableField<>();
    final ObservableInt mLang = new ObservableInt();

    public MeanViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void setWord(String word)
    {
        mWord.set(word);
    }

    public void setMean(String mean)
    {
        //Reformat for webview
        mean = HtmlConverter.String_htmlEncode(mean, getDataManager().getDictSource());
        float zoomScale = getDataManager().getZoomScale()/100.0f;
        mean = HtmlConverter.update4ViewPort(mean, zoomScale);

        mMean.set(mean);
    }

    public void setLang(int lang)
    {
        mLang.set(lang);
    }



    public ObservableField<String> getWord()
    {
        return mWord;
    }

    public ObservableField<String> getMean()
    {
        return mMean;
    }

    public ObservableInt getLang() {
        return mLang;
    }
}
