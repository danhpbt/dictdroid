package com.xynotec.dictdroid.ui.main.translate;

import android.app.Activity;
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

public class TranslateFragment extends BaseFragment<FragmentTranslateBinding, TranslateViewModel> {

    @BindView(R.id.spinnerFromLang)
    Spinner spinnerFromLang;

    @BindView(R.id.spinnerToLang)
    Spinner spinnerToLang;

    @BindView(R.id.buttonSwap)
    ImageView imageViewSwap;

    @BindView(R.id.btn_clear_input)
    ImageView imageViewClear;

    @BindView(R.id.buttonTranslate)
    Button buttonTranslate;

    @BindView(R.id.webViewTranslate)
    WebView wvTranslate;

    @Inject
    ViewModelProviderFactory factory;
    TranslateViewModel mTranslateViewModel;

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
        ArrayAdapter<CharSequence> language_adapter =
                (ArrayAdapter<CharSequence>) new ArrayAdapter(context, R.layout.spinner_item,
                        com.xynotec.dictdroid.data.GlobalData.mLanguages);
        language_adapter.setDropDownViewResource(R.layout.my_spinner_dropdown_item);

        imageViewClear.setVisibility(View.GONE);
        spinnerFromLang.setAdapter(language_adapter);
        spinnerToLang.setAdapter(language_adapter);

        imageViewSwap.setOnClickListener(onClickListener);
        imageViewClear.setOnClickListener(onClickListener);
        buttonTranslate.setOnClickListener(onClickListener);

        return view;
    }

    View.OnClickListener onClickListener = v -> {
        int id = v.getId();
        switch (id)
        {
            case R.id.buttonSwap:
                break;

            case R.id.btn_clear_input:
                break;

            case R.id.buttonTranslate:
                break;
        }
    };
}
