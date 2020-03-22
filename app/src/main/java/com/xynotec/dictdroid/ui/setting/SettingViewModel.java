package com.xynotec.dictdroid.ui.setting;

import android.widget.SeekBar;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;

public class SettingViewModel extends BaseViewModel {

    final ObservableField<String> strZoomScale = new ObservableField<>();
    final ObservableField<String> strZoomQScale = new ObservableField<>();
    final ObservableInt zoomScale = new ObservableInt();
    final ObservableInt zoomQScale = new ObservableInt();
    final ObservableBoolean bAutoLookup = new ObservableBoolean();

    public SettingViewModel(DataManager dataManager) {
        super(dataManager);

        zoomScale.set(getDataManager().getZoomScale());
        zoomQScale.set(getDataManager().getQZoomScale());
        strZoomScale.set(String.format("Text size: %d%%", zoomScale.get()));
        strZoomQScale.set(String.format("Text size: %d%%", zoomQScale.get()));
        bAutoLookup.set(getDataManager().getAutoLookup());
    }

    public ObservableField<String> getStringZoomScale()
    {
        return strZoomScale;
    }

    public ObservableField<String> getStringZoomQScale()
    {
        return strZoomQScale;
    }

    public int getZoomScale()
    {
        return zoomScale.get() - 100;
    }

    public int getZoomQScale()
    {
        return zoomQScale.get() - 100;
    }

    public void onZoomChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        if (fromUser)
        {
            int val = progress + 100;
            zoomScale.set(val);

            String str = String.format("Text size: %d%%", val);
            strZoomScale.set(str);

            getDataManager().setZoomScale(val);
        }
    }

    public void onZoomQChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        if (fromUser)
        {
            int val = progress + 100;
            zoomQScale.set(val);

            String str = String.format("Text size: %d%%", val);
            strZoomQScale.set(str);

            getDataManager().setQZoomScale(val);
        }
    }

    public ObservableBoolean getAutoLookup()
    {
        return bAutoLookup;
    }
}
