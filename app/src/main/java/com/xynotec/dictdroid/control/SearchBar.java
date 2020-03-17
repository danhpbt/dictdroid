package com.xynotec.dictdroid.control;

import com.xynotec.dictdroid.ende.R;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchBar extends FrameLayout 
{
	private OnSearchBarTextChange _onSearchBarTextChange;
	
	private EditText _editText;
	private ImageView _imgClear;
	private ImageView _imgVoice;
	private ImageView _imgSwap;

	final Context _context;

	public static String curText = "";

	public SearchBar(Context context)
	{
        this(context, null);
    }

    public SearchBar(Context context, AttributeSet attrs) 
    {
        super(context, attrs);
        
        _context = context;
        
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.ui_searchbar, this, true);
        
        _editText = findViewById(R.id.searchText);
        _editText.addTextChangedListener(_tw);

		_editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					String text = v.getText().toString();
					_onSearchBarTextChange.onTextSubmit(text);
					return true;
				}
				return false;
			}
		});
                
        _imgClear = findViewById(R.id.btn_clear);
        _imgClear.setVisibility(View.GONE);
        _imgClear.setOnClickListener(onClickListener);

		_imgVoice = findViewById(R.id.btn_voice_reg);
		_imgVoice.setVisibility(View.VISIBLE);
		_imgVoice.setOnClickListener(onClickListener);
    }

    public void hideVoiceRecognition()
	{
		_imgVoice.setVisibility(View.VISIBLE);
	}
    public void setHintText(String text)
    {
    	_editText.setHint(text);
    }
    
    public void setText(String text, boolean bSubmit)
    {
		_editText.setText(text);
		_editText.setSelection(text.length());

		if (bSubmit)
			_onSearchBarTextChange.onTextSubmit(text);
    }
    
    public void setOnSearchBarTextChange(OnSearchBarTextChange textChange)
    {
    	_onSearchBarTextChange = textChange;
    }
    
    private TextWatcher _tw = new TextWatcher() 
    {
		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			String textValue = arg0.toString();

            if (textValue.length() == 0) {
                _imgClear.setVisibility(View.GONE);
                _imgVoice.setVisibility(View.VISIBLE);
            }
            else {
                _imgClear.setVisibility(View.VISIBLE);
                _imgVoice.setVisibility(View.GONE);
            }

			if (textValue.equals(curText))
				return;

			curText = textValue;
			
			if (_onSearchBarTextChange != null)
				_onSearchBarTextChange.onTextChange(textValue);
		}
	};

	OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			int id = v.getId();
			switch (id)
			{
				case R.id.btn_clear:
					clearEditText();
					break;

				case R.id.btn_voice_reg:
					voiceRegconition();
					break;

			}
		}
	};

	public void clearEditText()
	{
		_editText.setText("");

		if(_editText.requestFocus())
		{
			InputMethodManager inputManager = (InputMethodManager)_context.getSystemService(Context.INPUT_METHOD_SERVICE);
			inputManager.showSoftInput(_editText, InputMethodManager.SHOW_IMPLICIT);
		}
	}

	public void voiceRegconition()
	{
		_onSearchBarTextChange.onGoogleVoice();
	}

	public interface OnSearchBarTextChange
	{
        void onTextChange(String text);
		void onTextSubmit(String text);
		void onGoogleVoice();
    }
}
