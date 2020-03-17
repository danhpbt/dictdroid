package com.xynotec.dictdroid.ui.main;

import android.content.Context;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.MainApplication;
import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.data.GlobalData;
import com.xynotec.dictdroid.engine.LangConst;

public class MainViewModel extends BaseViewModel {

    public final ObservableInt mSourceFlagResId = new ObservableInt();
    public final ObservableInt mDestinationFlagResId = new ObservableInt();
    public final ObservableField<String> mDictShortName = new ObservableField<>();
    public final ObservableField<String> mDictLongName = new ObservableField<>();
    public final ObservableField<String> mDictLongTitle = new ObservableField<>();

    public MainViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void openDict()
    {
        boolean bSwapDict = getDataManager().getSwapDict();
        String dictPath = bSwapDict ? GlobalData.DICT1_PATH : GlobalData.DICT2_PATH;
        getDataManager().openDict(dictPath);

        mDictShortName.set(getShortDictName(dictPath, true));
        mDictLongName.set(getLongDictName(dictPath, true));
        mDictLongTitle.set(getLongDictName(dictPath, false));
        mSourceFlagResId.set(flagSourceRes());
        mDestinationFlagResId.set(flagDestinationRes());
    }

    public void swapDict()
    {
        boolean bSwapDict = getDataManager().getSwapDict();
        getDataManager().setSwapDict(!bSwapDict);

        openDict();
    }

    String getShortDictName(String dictFile, boolean bSuffix)
    {
        if (dictFile.length() < 4)
            return null;

        String fromLang = dictFile.substring(0, 2).toUpperCase();
        String toLang = dictFile.substring(2, 4).toUpperCase();

        String nameDict;
        if (bSuffix)
            nameDict = String.format("%s-%s Dict", fromLang, toLang);
        else
            nameDict = String.format("%s-%s", fromLang, toLang);
        return nameDict;
    }

    String getLongDictName(String dictFile, boolean bSuffix)
    {
        if (dictFile.length() < 4)
            return null;

        String fromLang = LangConst.getLanguage(dictFile.substring(0, 2).toLowerCase());
        String toLang = LangConst.getLanguage(dictFile.substring(2, 4).toLowerCase());

        if (fromLang == null)
            fromLang = "FromLang";
        if (toLang == null)
            toLang = "ToLang";

        String nameDict;
        if (bSuffix)
            nameDict = String.format("%s-%s Dictionary", fromLang, toLang);
        else
            nameDict = String.format("%s-%s", fromLang, toLang);
        return nameDict;
    }

    public ObservableField<String> getDictLongName()
    {
        return mDictLongName;
    }

    public ObservableField<String> getDictLongTitle()
    {
        return mDictLongTitle;
    }

    public ObservableField<String> getDictShortName()
    {
        return mDictShortName;
    }



    int flagSourceRes()
    {
        String symbol = LangConst.getSymbol(getDataManager().getSourceLang());
        String flagFrom = String.format("flag_%s", symbol);

        Context context = MainApplication.getContext();
        int resId = context.getResources().getIdentifier(flagFrom, "drawable", context.getPackageName());
        return resId;
    }

    int flagDestinationRes()
    {
        String symbol = LangConst.getSymbol(getDataManager().getDestinationLang());
        String flagFrom = String.format("flag_%s", symbol);

        Context context = MainApplication.getContext();
        int resId = context.getResources().getIdentifier(flagFrom, "drawable", context.getPackageName());
        return resId;
    }

    public ObservableInt getFlagSourceRes()
    {
        return mSourceFlagResId;
    }

    public ObservableInt getFlagDestinationRes()
    {
        return mDestinationFlagResId;
    }

}
