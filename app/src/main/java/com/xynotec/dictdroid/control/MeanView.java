package com.xynotec.dictdroid.control;

import com.xynotec.dagger.BaseActivity;
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

import javax.inject.Inject;

import butterknife.BindView;

public class MeanView extends LinearLayout
{
	//Mean View
	private static final String MIMETYPE = "text/html";
	private static final String ENCODING = "UTF-8";
	
	private Context _context;
	private String _word;
	private String _mean;

	ImageView _btnFavorite;
	ImageView _btnSpeaker;
	TextView _textWord;
	WebView _webMean;

//	MeanviewBinding meanviewBinding;
//	MeanViewModel meanViewModel;

	public MeanView(Context context) {
		this(context, null);
	}

	public MeanView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MeanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		_context = context;

//        LayoutInflater inflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.meanview, this, true);

//		meanviewBinding = MeanviewBinding.inflate(LayoutInflater.from(context), this, false);
//		meanviewBinding.setViewModel(meanViewModel);

		LayoutInflater inflater = (LayoutInflater)
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.meanview, this, true);

//		meanviewBinding = MeanviewBinding.inflate(inflater);

//		BaseActivity baseActivity = (BaseActivity) (_context);
//		meanViewModel = new MeanViewModel(baseActivity.getDataManager());
//		meanviewBinding.setViewModel(meanViewModel);
//		meanviewBinding.executePendingBindings();
//		meanviewBinding.setLifecycleOwner(baseActivity);

        _btnFavorite = findViewById(R.id.btnFavorite);
		_btnFavorite.setOnClickListener(favoriteClick);

		_btnSpeaker = findViewById(R.id.btnSpeaker);
		_btnSpeaker.setOnClickListener(speakerClick);

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


	//	public MeanView(Context context)
//	{
//        this(context, null);
//		_context = context;
//	}
//
//    public MeanView(Context context, AttributeSet attrs)
//    {
//        super(context, attrs);
//        _context = context;
//
//        LayoutInflater inflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.meanview, this, true);
//
//        _btnFavorite = findViewById(R.id.btnFavorite);
//		_btnFavorite.setOnClickListener(favoriteClick);
//
//		_btnSpeaker = findViewById(R.id.btnSpeaker);
//		_btnSpeaker.setOnClickListener(speakerClick);
//
//		_textWord = findViewById(R.id.textWord);
//
//
//		_webMean = findViewById(R.id.wb_wordMean);
//		if(!isInEditMode())
//			_webMean.getSettings().setJavaScriptEnabled(true);
//		_webMean.setWebViewClient(new WebViewClient()
//		{
//			@Override public boolean shouldOverrideUrlLoading(WebView view, String url)
//			{
//				return false;
//			}
//
//			@Override
//			public void onPageFinished(WebView view, String url) {
//				// TODO Auto-generated method stub
//				super.onPageFinished(view, url);
//			}
//		});
//    }


    
    public void setWordMean(String word, String mean)
    {
//        meanViewModel.setWordMean(word, mean);
//    	_word = word;
//    	_mean = mean;
//
//		updateFavorite(word);
//		updateTTSControl();
//
//		_textWord.setText(_word);
//
//		float zoomScale = appPreferencesHelper.getZoomScale()/100.0f;
//
//		_webMean.loadDataWithBaseURL(null, HtmlConverter.update4ViewPort(mean, zoomScale),
//				MIMETYPE, ENCODING, "about:blank");
    }



	public void updateFavorite(String word)
	{
//		if(appDbHelper.existFavorite(word))
//			_btnFavorite.setImageDrawable(ContextCompat.getDrawable(_context, R.drawable.ic_favorite));
//		else
//			_btnFavorite.setImageDrawable(ContextCompat.getDrawable(_context, R.drawable.ic_no_favorite));
	}

    void updateTTSControl()
    {
//		if(TTS.getInstance().canSpeak())
//			_btnSpeaker.setVisibility(View.VISIBLE);
//		else
//			_btnSpeaker.setVisibility(View.GONE);
    }
    
    private OnClickListener favoriteClick = v -> {
		// TODO Auto-generated method stub
//			if(appDbHelper.existFavorite(_word))
//			{
//				_btnFavorite.setImageDrawable(ContextCompat.getDrawable(_context, R.drawable.ic_no_favorite));
//				//DictDbHelper.getInstance().RemoveFavorite(_word);
//			}
//			else
//			{
//				_btnFavorite.setImageDrawable(ContextCompat.getDrawable(_context, R.drawable.ic_favorite));
//				appDbHelper.insertFavorite(new Favorite(_word, _mean));
//				//DictDbHelper.getInstance().AddFavorite(_word, _mean);
//			}
	};
	
	private OnClickListener speakerClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Speak(_word);
		}
	};
	
	private void Speak(String word)
	{
//		boolean bTTS = GlobalData.getTTSEngine(_context);
//    	if (bTTS)
//    		TTS.getInstance().speak(word);

	}

	public void Speak()
	{
		Log.d("TAG", "Speak: ");
	}

}
