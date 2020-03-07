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

	public static String curText = "";

	public SearchBar(Context context)
	{
        this(context, null);
    }

    public SearchBar(Context context, AttributeSet attrs) 
    {
        super(context, attrs);
        
        final Context _context = context;
        
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
        _imgClear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				_editText.setText("");

				if(_editText.requestFocus()) 
				{
					InputMethodManager inputManager = (InputMethodManager)_context.getSystemService(Context.INPUT_METHOD_SERVICE);
					inputManager.showSoftInput(_editText, InputMethodManager.SHOW_IMPLICIT);
				}
				
				
			}
		});

		_imgVoice = findViewById(R.id.btn_voice_reg);
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
    
    public void hideEmulatorKeyboard(Activity activity)
	{
		//Method 1
		if (activity != null)
		{
			InputMethodManager inputManager = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			inputManager.hideSoftInputFromWindow(_editText.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
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


	
	public interface OnSearchBarTextChange 
	{
        void onTextChange(String text);
		void onTextSubmit(String text);
    }
}
