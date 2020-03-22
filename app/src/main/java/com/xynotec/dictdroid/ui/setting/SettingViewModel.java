package com.xynotec.dictdroid.ui.setting;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;

public class SettingViewModel extends BaseViewModel {

    final ObservableField<String> strZoomScale = new ObservableField<>();
    final ObservableField<String> strQZoomScale = new ObservableField<>();
    final ObservableInt zoomScale = new ObservableInt();
    final ObservableInt zoomQScale = new ObservableInt();
    final ObservableBoolean bAutoLookup = new ObservableBoolean();

    public SettingViewModel(DataManager dataManager) {
        super(dataManager);

        zoomScale.set(getDataManager().getZoomScale());
        zoomQScale.set(getDataManager().getQZoomScale());
        bAutoLookup.set(getDataManager().getAutoLookup());
    }

    public ObservableField<String> getStringZoomScale()
    {
        int zoom = zoomScale.get();
        String str = String.format("Text size: %d%%", zoom);
        strZoomScale.set(str);
        return strZoomScale;
    }

    public ObservableField<String> getStringQZoomScale()
    {
        int zoomQ = zoomQScale.get();
        String str = String.format("Text size: %d%%", zoomQ);
        strQZoomScale.set(str);
        return strQZoomScale;
    }

    public ObservableInt getZoomScale()
    {
        return zoomScale;
    }

    public ObservableInt getQZoomScale()
    {
        return zoomQScale;
    }

    public ObservableBoolean getAutoLookup()
    {
        return bAutoLookup;
    }
}
