package com.xynotec.dictdroid.ui.base.viewmodel;

import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;
import com.xynotec.dictdroid.engine.LangConst;
import com.xynotec.dictdroid.utils.HtmlConverter;

import java.util.Locale;

public class BaseMeanViewModel extends BaseViewModel {

    String mOrginMean;

    final ObservableField<String> mWord = new ObservableField<>();
    final ObservableField<String> mMean = new ObservableField<>();
    final ObservableBoolean mInFav = new ObservableBoolean();
    final ObservableField<Locale> mLccale = new ObservableField<>();
    final ObservableInt mZoomScale = new ObservableInt();

    public BaseMeanViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void setMean(String word, String mean)
    {
        //Reformat for webview
        mOrginMean = mean;

        mean = HtmlConverter.String_htmlEncode(mean, getDataManager().getDictSource());

        int sourceLang = getDataManager().getSourceLang();
        Locale locale = LangConst.getLocale(sourceLang);
        boolean inFav = getDataManager().existFavorite(word);

        mWord.set(word);
        mMean.set(mean);
        mLccale.set(locale);
        mZoomScale.set(getDataManager().getZoomScale());
        mInFav.set(inFav);
    }

    public ObservableField<String> getWord()
    {
        return mWord;
    }

    public ObservableField<String> getMean()
    {
        return mMean;
    }

    public ObservableField<Locale> getLocale() { return mLccale;}

    public void setZoomScale(int zoomScale)
    {
        mZoomScale.set(zoomScale);
    }

    public ObservableInt getZoomScale()
    {
        return mZoomScale;
    }

    public ObservableBoolean getInFav() {
        return mInFav;
    }

    public void toggleFavorite()
    {
        String word = mWord.get();
        boolean inFav = mInFav.get();
        if (inFav)
            getDataManager().deleteFavorite(word);
        else {
            Favorite favorite = new Favorite();
            favorite.setWordMean(mWord.get(), mOrginMean, getDataManager().getSourceLang());
            getDataManager().insertFavorite(favorite);
        }

        mInFav.set(!inFav);
    }
}
