package com.xynotec.dictdroid.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dagger.BaseActivity;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.ActivityLoginBinding;

import javax.inject.Inject;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    @BindView(R.id.bt_login)
    Button btnLogin;

    @Inject
    ViewModelProviderFactory factory;
    private LoginViewModel mLoginViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public int getBindingVariable() {
        return BR.loginVM;
    }

    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = new ViewModelProvider(this, factory).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    static int count = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count % 2 == 0)
                    mLoginViewModel.setUserName("pbtdanh");
                else
                    mLoginViewModel.setUserName("Hint text");
                mLoginViewModel.setPassWord("chaudanh");
            }
        });
    }


}
