package com.xynotec.dictdroid.control;

import com.xynotec.common.TTS;
import com.xynotec.dagger.BaseActivity;
import com.xynotec.dictdroid.MainApplication;
import com.xynotec.dictdroid.data.AppDataManager;
import com.xynotec.dictdroid.data.local.db.AppDbHelper;
import com.xynotec.dictdroid.data.local.prefs.AppPreferencesHelper;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ui.main.MainViewModel;
import com.xynotec.dictdroid.utils.HtmlConverter;

import android.app.Application;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;

public class MeanView extends LinearLayout
{
	//Mean View
	private static final String MIMETYPE = "text/html";
	private static final String ENCODING = "UTF-8";

	ImageView _btnFavorite;
	ImageView _btnSpeaker;
	TextView _textWord;
	WebView _webMean;

	String mWord;
	String mMean;
	Locale mLocale;

	Context mContext;

	private OnMeanviewListener mListener;

	public MeanView(Context context) {
		this(context, null);
	}

	public MeanView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MeanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		mContext = context;

		mWord = mMean = "";
		mLocale = Locale.getDefault();

		LayoutInflater inflater = (LayoutInflater)
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.meanview, this, true);

        _btnFavorite = findViewById(R.id.btnFavorite);
		_btnFavorite.setOnClickListener(ooClickListener);

		_btnSpeaker = findViewById(R.id.btnSpeaker);
		_btnSpeaker.setOnClickListener(ooClickListener);

		_textWord = findViewById(R.id.textWord);

		_webMean = findViewById(R.id.wb_wordMean);
		if(!isInEditMode())
			_webMean.getSettings().setJavaScriptEnabled(true);
		_webMean.setWebViewClient(new WebViewClient()
		{
			@Override public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				return false;
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				// TODO Auto-generated method stub
				super.onPageFinished(view, url);
			}
		});
	}

    public void setWordMean(String word, String mean, boolean bInFavorite, Locale locale)
    {
    	if (word == null || mean == null || locale == null)
    		return;

    	if (word.compareTo(mWord) != 0)
    		mWord = word;

    	if (mean.compareTo(mMean) != 0)
    		mMean = mean;

    	if (!locale.equals(mLocale))
		{
			mLocale = locale;
			TTS.getInstance().setTTSLanguage(locale);
		}

    	if (bInFavorite)
			_btnFavorite.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_favorite));
		else
			_btnFavorite.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_no_favorite));

		if (TTS.getInstance().isSupportTTS())
			_btnSpeaker.setVisibility(View.VISIBLE);
		else
			_btnSpeaker.setVisibility(View.GONE);

		_textWord.setText(word);
		_webMean.loadDataWithBaseURL(null, mean,
				MIMETYPE, ENCODING, "about:blank");

	}
	
	private OnClickListener ooClickListener = v -> {
		int id = v.getId();
		switch (id)
		{
			case R.id.btnSpeaker:
				TTS.getInstance().speak(mWord);
				break;

			case R.id.btnFavorite:
				mListener.onClickFavorite();
				break;
		}
	};

	public void setListener(OnMeanviewListener listener)
	{
		mListener = listener;
	}

	public interface OnMeanviewListener
	{
		void onClickFavorite();
	}

}
