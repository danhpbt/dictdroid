package com.xynotec.dictdroid.ui.mean;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;

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
