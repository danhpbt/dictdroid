package com.xynotec.dictdroid.ui.mean;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.engine.LangConst;
import com.xynotec.dictdroid.ui.base.viewmodel.BaseMeanViewModel;
import com.xynotec.dictdroid.utils.HtmlConverter;

import java.util.Locale;

public class MeanViewModel extends BaseMeanViewModel {

    public MeanViewModel(DataManager dataManager) {
        super(dataManager);
    }
}
