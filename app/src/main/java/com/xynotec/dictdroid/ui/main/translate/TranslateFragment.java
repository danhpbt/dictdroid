package com.xynotec.dictdroid.ui.main.translate;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.xynotec.dagger.BaseFragment;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentFavoriteBinding;
import com.xynotec.dictdroid.ende.databinding.FragmentTranslateBinding;
import com.xynotec.dictdroid.ui.main.favorite.FavoriteViewModel;

import javax.inject.Inject;

import butterknife.BindView;

public class TranslateFragment extends BaseFragment<FragmentTranslateBinding, TranslateViewModel>
        implements TranslateViewModel.TranslateViewModelListener {

    @BindView(R.id.spinnerFromLang)
    Spinner spinnerFromLang;

    @BindView(R.id.spinnerToLang)
    Spinner spinnerToLang;

    @BindView(R.id.btn_clear_input)
    ImageView imageViewClear;

    @Inject
    ViewModelProviderFactory factory;
    TranslateViewModel mTranslateViewModel;

    ProgressDialog mProgressDialog;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_translate;
    }

    @Override
    public int getBindingVariable() {
        return BR.translateVM;
    }

    @Override
    public TranslateViewModel getViewModel() {
        mTranslateViewModel = new ViewModelProvider(this, factory).get(TranslateViewModel.class);
        return mTranslateViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        Activity context = getActivity();

        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage("Translating...");
        mProgressDialog.setCancelable(false);

        mTranslateViewModel.setListener(this);

        ArrayAdapter<CharSequence> language_adapter =
                (ArrayAdapter<CharSequence>) new ArrayAdapter(context, R.layout.spinner_item,
                        com.xynotec.dictdroid.data.GlobalData.mLanguages);
        language_adapter.setDropDownViewResource(R.layout.my_spinner_dropdown_item);

        imageViewClear.setVisibility(View.GONE);
        spinnerFromLang.setAdapter(language_adapter);
        spinnerToLang.setAdapter(language_adapter);

        return view;
    }

    @Override
    public void onShowProgressDlg(boolean bShow) {
        if (bShow)
            mProgressDialog.show();
        else
        {
            if (mProgressDialog != null && mProgressDialog.isShowing())
                mProgressDialog.dismiss();
        }
    }


}
