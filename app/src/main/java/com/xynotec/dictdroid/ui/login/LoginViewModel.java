package com.xynotec.dictdroid.ui.login;

import androidx.databinding.ObservableField;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;

public class LoginViewModel extends BaseViewModel {

    public final ObservableField<String> mUserName = new ObservableField<>();
    public final ObservableField<String> mPassWord = new ObservableField<>();

    public LoginViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public ObservableField<String> getUserName()
    {
        return mUserName;
    }

    public ObservableField<String> getPassWord()
    {
        return mPassWord;
    }

    public void setUserName(String userName)
    {
        mUserName.set(userName);
    }

    public void setPassWord(String passWord)
    {
        mPassWord.set(passWord);
    }

}
