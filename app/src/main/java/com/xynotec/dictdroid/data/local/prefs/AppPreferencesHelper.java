package com.xynotec.dictdroid.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;

import com.xynotec.utils.DeviceUtils;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper{
    final static String PREF_NAME = "HorizonCache";

    final static String FROMLANGSETTING = "FromLangSetting";
    final static String TOLANGSETTING = "ToLangSetting";
    final static String SWAPDICTSETTING = "SwapDictSetting";
//    final static String DOWNLOADDICT = "DownloadDictSetting";
//    final static String CURRENTDICT = "CurrentDictSetting";
    final static String REMOVEADSSETTING = "RemovedAds";
    final static String APPVERSIONSETTING = "AppVersion";
    final static String TTS_ENGINE_SETTING = "TTSEngineSetting";
    final static String ZOOM_SCALE_SETTING = "ZoomScaleSetting";
    final static String QS_ZOOM_SCALE_SETTING = "QSearchZoomScaleSetting";
    final static String AUTO_LOOKUP_SETTING = "AutoLookupSetting";
    final static String POPUP_POS_X_SETTING = "PopUpPosXSetting";
    final static String POPUP_POS_Y_SETTING = "PopUpPosYSetting";
    final static String POPUP_SIZE_W_SETTING = "PopUpSizeWSetting";
    final static String POPUP_SIZE_H_SETTING = "PopUpSizeHSetting";
//    final static String PERMISSION_STORGATE_SETTING = "PermissionStorageSetting";
//    final static String QS_USER_GUIDE_SETTING = "QSearchUserGuideSetting";

    private final SharedPreferences mPrefs;
    private final Context mContext;

    @Inject
    public AppPreferencesHelper(Context context) {
        mContext = context;
        mPrefs = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setFromLangRecentIndex(int index)
    {
        mPrefs.edit().putInt(FROMLANGSETTING, index).apply();
    }

    @Override
    public int getFromLangRecentIndex()
    {
        return mPrefs.getInt(FROMLANGSETTING, 0);
    }

    @Override
    public void setToLangRecentIndex(int index)
    {
        mPrefs.edit().putInt(TOLANGSETTING, index).apply();
    }

    @Override
    public int getToLangRecentIndex()
    {
        return mPrefs.getInt(TOLANGSETTING, 0);
    }

    @Override
    public void setSwapDict(boolean bSwap)
    {
        mPrefs.edit().putBoolean(SWAPDICTSETTING, bSwap).apply();
    }

    @Override
    public boolean getSwapDict()
    {
        return mPrefs.getBoolean(SWAPDICTSETTING, false);
    }

    @Override
    public void setRemoveAds(boolean bRemoved)
    {
        mPrefs.edit().putBoolean(REMOVEADSSETTING, bRemoved).apply();
    }

    @Override
    public boolean getRemovedAds()
    {
        return mPrefs.getBoolean(REMOVEADSSETTING, false);
    }

    @Override
    public void setAppCodeVersion(int codeVersion)
    {
        mPrefs.edit().putInt(APPVERSIONSETTING, codeVersion).apply();
    }

    @Override
    public int getAppCodeVersion()
    {
        return mPrefs.getInt(APPVERSIONSETTING, 0);
    }

    @Override
    public void setTTSEngine(boolean bTTS)
    {
        mPrefs.edit().putBoolean(TTS_ENGINE_SETTING, bTTS).apply();
    }

    @Override
    public boolean getTTSEngine()
    {
        return mPrefs.getBoolean(TTS_ENGINE_SETTING, true);
    }

    @Override
    public void setZoomScale(int scale)
    {
        mPrefs.edit().putInt(ZOOM_SCALE_SETTING, scale).apply();
    }

    @Override
    public int getZoomScale()
    {
        return mPrefs.getInt(ZOOM_SCALE_SETTING, 150);
    }

    @Override
    public void setQSZoomScale(int scale)
    {
        mPrefs.edit().putInt(QS_ZOOM_SCALE_SETTING, scale).apply();
    }

    @Override
    public int getQSZoomScale()
    {
        return mPrefs.getInt(QS_ZOOM_SCALE_SETTING, 100);
    }

    @Override
    public void setAutoLookup(boolean bAutoLookup)
    {
        mPrefs.edit().putBoolean(AUTO_LOOKUP_SETTING, bAutoLookup).apply();
    }

    @Override
    public boolean getAutoLookup()
    {
        return mPrefs.getBoolean(AUTO_LOOKUP_SETTING, false);
    }

    @Override
    public void setPopUpPosX(int posX)
    {
        mPrefs.edit().putInt(POPUP_POS_X_SETTING, posX).apply();
    }

    @Override
    public int getPopUpPosX()
    {
        return mPrefs.getInt(POPUP_POS_X_SETTING, 0);
    }

    @Override
    public void setPopUpPosY(int posY)
    {
        mPrefs.edit().putInt(POPUP_POS_Y_SETTING, posY).apply();
    }

    @Override
    public int getPopUpPosY()
    {
        return mPrefs.getInt(POPUP_POS_X_SETTING, 0);
    }

    @Override
    public void setPopUpSizeWidth(int width)
    {
        mPrefs.edit().putInt(POPUP_SIZE_W_SETTING, width).apply();
    }

    @Override
    public int getPopUpSizeWidth()
    {
        Point sizeScreen = DeviceUtils.getDisplaySize(mContext);
        int screenW = sizeScreen.x;
        final float DEFAULT_POPUPSIZE_W = 0.6f;

        int defaultWidth = (int)(DEFAULT_POPUPSIZE_W*screenW);//default 0.6 screenWidth

        return mPrefs.getInt(POPUP_SIZE_W_SETTING, defaultWidth);
    }

    @Override
    public void setPopUpSizeHeight(int height)
    {
        mPrefs.edit().putInt(POPUP_SIZE_H_SETTING, height).apply();
    }

    @Override
    public int getPopUpSizeHeight()
    {
        Point sizeScreen = DeviceUtils.getDisplaySize(mContext);
        int screenH = sizeScreen.y;
        final float DEFAULT_POPUPSIZE_H = 0.4f;

        int defaultHeight = (int)(DEFAULT_POPUPSIZE_H*screenH);//default 0.4 screenHeight

        return mPrefs.getInt(POPUP_SIZE_H_SETTING, defaultHeight);
    }

}
