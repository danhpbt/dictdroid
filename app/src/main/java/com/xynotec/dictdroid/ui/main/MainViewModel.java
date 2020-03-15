package com.xynotec.dictdroid.ui.main;

import androidx.databinding.ObservableField;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.data.GlobalData;
import com.xynotec.dictdroid.engine.LangConst;

public class MainViewModel extends BaseViewModel {

    final ObservableField<String> mDictShortName = new ObservableField<>();
    final ObservableField<String> mDictLongName = new ObservableField<>();

    public MainViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void openDict()
    {
        boolean bSwapDict = getDataManager().getSwapDict();
        String dictPath = bSwapDict ? GlobalData.DICT1_PATH : GlobalData.DICT2_PATH;
        getDataManager().openDict(dictPath);

        String shortName = getShortDictName(dictPath, true);
        String longName = getLongDictName(dictPath, true);

        mDictShortName.set(shortName);
        mDictLongName.set(longName);
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
}
