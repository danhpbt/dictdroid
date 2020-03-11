package com.xynotec.dictdroid.ui.main.search;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;

public class SearchViewModel extends BaseViewModel {

    private static final String TAG = "SearchViewModel";

    final ObservableField<String> mWord = new ObservableField<>("Danh test");
    final ObservableField<String> mMean = new ObservableField<>();

//    public SearchViewModel(DataManager dataManager) {
//        super(dataManager);
//        mWord = new ObservableField<>();
//        mMean = new ObservableField<>();
//    }

//    public void setWordMean(String word, String mean)
//    {
//        mWord.set(word);
//        mMean.set(mean);
//    }

    public String getWord()
    {
        return mWord.get();
    }
    
    public void onSpeakerClick()
    {
        Log.d(TAG, "onSpeakerClick: ");    
    }
}
