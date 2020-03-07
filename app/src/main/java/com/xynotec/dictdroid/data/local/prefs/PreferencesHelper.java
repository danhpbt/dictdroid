package com.xynotec.dictdroid.data.local.prefs;

public interface PreferencesHelper {

    void setFromLangRecentIndex(int index);
    int getFromLangRecentIndex();
    void setToLangRecentIndex(int index);
    int getToLangRecentIndex();
    void setSwapDict(boolean bSwap);
    boolean getSwapDict();
    void setRemoveAds(boolean bRemoved);
    boolean getRemovedAds();
    void setAppCodeVersion(int codeVersion);
    int getAppCodeVersion();
    void setTTSEngine(boolean bTTS);
    boolean getTTSEngine();
    void setZoomScale(int scale);
    int getZoomScale();
    void setQSZoomScale(int scale);
    int getQSZoomScale();
    void setAutoLookup(boolean bAutoLookup);
    boolean getAutoLookup();
    void setPopUpPosX(int posX);
    int getPopUpPosX();
    void setPopUpPosY(int posY);
    int getPopUpPosY();
    void setPopUpSizeWidth(int width);
    int getPopUpSizeWidth();
    void setPopUpSizeHeight(int height);
    int getPopUpSizeHeight();

}
