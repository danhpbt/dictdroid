package com.xynotec.dictdroid.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.xynotec.dictdroid.data.local.db.DbHelper;
import com.xynotec.dictdroid.data.local.prefs.PreferencesHelper;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;
import com.xynotec.dictdroid.engine.DictEngine;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";

    private final Context mContext;

    private final DictEngine mDictEngine;

    private final DbHelper mDbHelper;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context mContext, DictEngine dictEngine, DbHelper mDbHelper, PreferencesHelper mPreferencesHelper) {
        this.mDictEngine = dictEngine;
        this.mContext = mContext;
        this.mDbHelper = mDbHelper;
        this.mPreferencesHelper = mPreferencesHelper;
    }

    @Override
    public void openDict(String path) {
        mDictEngine.OpenDict(path);
    }

    @Override
    public int numWordInDict() {
        return mDictEngine.GetNumWordInDic();
    }

    @Override
    public int getDictSource() {
        return mDictEngine.getDataSource();
    }

    @Override
    public int getSourceLang() {
        return mDictEngine.getSourceLang();
    }

    @Override
    public String getDictWord(int index) {
        return mDictEngine.GetWord(index);
    }

    @Override
    public String getMeanWord(int index) {
        return mDictEngine.GetMeanWord(index);
    }

    @Override
    public int onDictSearch(String word) {
        return mDictEngine.OnEditSearch(word);
    }

    @Override
    public LiveData<List<History>> getHistories()
    {
        return mDbHelper.getHistories();
    }

    @Override
    public LiveData<List<Favorite>> getFavorites()
    {
        return mDbHelper.getFavorites();
    }

    @Override
    public void insertHistory(History history)
    {
        mDbHelper.insertHistory(history);
    }

    @Override
    public void insertFavorite(Favorite favorite)
    {
        mDbHelper.insertFavorite(favorite);
    }

    public boolean existHistory(String history)
    {
        return mDbHelper.existHistory(history);
    }

    public boolean existFavorite(String favorite)
    {
        return mDbHelper.existFavorite(favorite);
    }

    public void setFromLangRecentIndex(int index)
    {
        mPreferencesHelper.setFromLangRecentIndex(index);
    }

    public int getFromLangRecentIndex()
    {
        return mPreferencesHelper.getFromLangRecentIndex();
    }

    public void setToLangRecentIndex(int index)
    {
        mPreferencesHelper.setToLangRecentIndex(index);
    }

    public int getToLangRecentIndex()
    {
        return mPreferencesHelper.getToLangRecentIndex();
    }

    public void setSwapDict(boolean bSwap)
    {
        mPreferencesHelper.setSwapDict(bSwap);
    }

    public boolean getSwapDict()
    {
        return mPreferencesHelper.getSwapDict();
    }

    public void setRemoveAds(boolean bRemoved)
    {
        mPreferencesHelper.setRemoveAds(bRemoved);
    }

    public boolean getRemovedAds()
    {
        return mPreferencesHelper.getRemovedAds();
    }

    public void setAppCodeVersion(int codeVersion)
    {
        mPreferencesHelper.setAppCodeVersion(codeVersion);
    }

    public int getAppCodeVersion()
    {
        return mPreferencesHelper.getAppCodeVersion();
    }

    public void setTTSEngine(boolean bTTS)
    {
        mPreferencesHelper.setTTSEngine(bTTS);
    }

    public boolean getTTSEngine()
    {
        return mPreferencesHelper.getTTSEngine();
    }

    public void setZoomScale(int scale)
    {
        mPreferencesHelper.setZoomScale(scale);
    }

    @Override
    public int getZoomScale()
    {
        return mPreferencesHelper.getZoomScale();
    }

    public void setQSZoomScale(int scale)
    {
        mPreferencesHelper.setQSZoomScale(scale);
    }

    public int getQSZoomScale()
    {
        return mPreferencesHelper.getQSZoomScale();
    }

    public void setAutoLookup(boolean bAutoLookup)
    {
        mPreferencesHelper.setAutoLookup(bAutoLookup);
    }

    public boolean getAutoLookup()
    {
        return mPreferencesHelper.getAutoLookup();
    }

    public void setPopUpPosX(int posX)
    {
        mPreferencesHelper.setPopUpPosX(posX);
    }

    public int getPopUpPosX()
    {
        return mPreferencesHelper.getPopUpPosX();
    }

    public void setPopUpPosY(int posY)
    {
        mPreferencesHelper.setPopUpPosY(posY);
    }

    public int getPopUpPosY()
    {
        return mPreferencesHelper.getPopUpPosY();
    }

    public void setPopUpSizeWidth(int width)
    {
        mPreferencesHelper.setPopUpSizeWidth(width);
    }

    public int getPopUpSizeWidth()
    {
        return mPreferencesHelper.getPopUpSizeWidth();
    }

    public void setPopUpSizeHeight(int height)
    {
        mPreferencesHelper.setPopUpSizeHeight(height);
    }

    public int getPopUpSizeHeight()
    {
        return mPreferencesHelper.getPopUpSizeHeight();
    }
}
