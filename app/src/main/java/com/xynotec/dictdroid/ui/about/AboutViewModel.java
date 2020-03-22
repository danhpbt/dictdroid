package com.xynotec.dictdroid.ui.about;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;

public class AboutViewModel extends BaseViewModel {

    private static final String TAG = "AboutViewModel";

    String mVersion = "1.0.0";
    public AboutViewModel(DataManager dataManager) {
        super(dataManager);

        try
        {
            Context context = getDataManager().getContext();
            PackageInfo pinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            mVersion = pinfo.versionName;
        }
        catch (Exception e)
        {
            Log.d(TAG, "AboutViewModel: " + e.getLocalizedMessage());
        }

    }

    public String getVersion()
    {
        return mVersion;
    }
}
