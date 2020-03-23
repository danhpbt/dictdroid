//package com.xynotec.dictdroid.floatview;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.graphics.PixelFormat;
//import android.graphics.Point;
//import android.os.Build;
//import android.os.Handler;
//import android.os.Looper;
//import android.provider.Settings;
//import android.support.v7.app.AlertDialog;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.Gravity;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.WindowManager;
//import android.view.inputmethod.EditorInfo;
//import android.view.inputmethod.InputMethodManager;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.AdapterView;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//import android.widget.ViewFlipper;
//
//import com.xynotec.dictdroid.ende.R;
//import com.xynotec.dictdroid.adapters.FloatWordEfficientAdapter;
//import com.xynotec.dictdroid.common.TTS;
//import com.xynotec.dictdroid.data.GlobalData;
//import com.xynotec.dictdroid.data.LangConst;
//import com.xynotec.dictdroid.db.DictDbHelper;
//import com.xynotec.dictdroid.engine.DictEngine;
//import com.xynotec.dictdroid.service.QuickSearchService;
//import com.xynotec.dictdroid.util.HtmlConverter;
//import com.xynotec.util.GoogleTranslateSpeaker;
//import com.xynotec.util.MoveFrameLayout;
//import com.xynotec.util.Util;
//
///**
// * Created by Danh Phan on 9/22/2016.
// */
//public class QuickSearchView {
//
//
//    Context mContext;
//    WindowManager windowManager;
//
//    static final float MIN_POPUPSIZE_W = 0.5f;
//    static final float MIN_POPUPSIZE_H = 0.3f;
//
//    int minWidth, minHeight;
//    int orgWidth, orgHeight;
//    int orgPosX, orgPosY;
//
//    QuickViewSearchListener quickViewSearchListener;
//    MoveFrameLayout mainView;
//    FrameLayout moveFrameView;
//
//    //Const
//    final static int SEARCH_VIEW = 0;
//    final static int MEAN_VIEW = 1;
//
//    private static int curView = SEARCH_VIEW;
//
//    ViewFlipper viewFlipper;
//    WebView meanView;
//    ListView listViewWord;
//    EditText editText;
//
//
//    LinearLayout wordOption;
//    ImageView speakerImg;
//    ImageView favImg;
//    ImageView clearImg;
//
//    String word, mean;
//
//    FloatWordEfficientAdapter dictAdapter;
//
//
//    private GoogleTranslateSpeaker googleSpeaker;
//
//    public QuickSearchView(Context context)
//    {
//        mContext = context;
//        windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
//        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        mainView = (MoveFrameLayout) inflater.inflate(R.layout.popup_main, null);
//        moveFrameView = (FrameLayout) mainView.findViewById(R.id.moveLayer);
//        mainView.setOnMoveResizeListener(moveResizeListener);
//
//        WindowManager.LayoutParams paramsMainView = buildLayoutParamsForMainView();
//        windowManager.addView(mainView, paramsMainView);
//
//
//
//        //////////////////GUI for user
//        viewFlipper = (ViewFlipper) mainView.findViewById(R.id.viewFlipper);
//        listViewWord = (ListView) mainView.findViewById(R.id.listWord);
//        editText = (EditText) mainView.findViewById(R.id.editText);
//        wordOption = (LinearLayout) mainView.findViewById(R.id.wordOption);
//
//        speakerImg = (ImageView) mainView.findViewById(R.id.imgSpeaker);
//        favImg = (ImageView) mainView.findViewById(R.id.imgFav);
//        clearImg = (ImageView) mainView.findViewById(R.id.imgClear);
//
//        //Set listener
//        speakerImg.setOnClickListener(imgClick);
//        favImg.setOnClickListener(imgClick);
//        clearImg.setOnClickListener(imgClick);
//        //voiceImg.setOnClickListener(imgClick);
//
//        meanView = (WebView) mainView.findViewById(R.id.meanView);
//        ////disable text selection
//        meanView.setLongClickable(false);
//        meanView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                return true;
//            }
//        });
//        ///////////////////////////////
//
//        meanView.getSettings().setJavaScriptEnabled(true);
//        meanView.setWebViewClient(new WebViewClient()
//        {
//            @Override public boolean shouldOverrideUrlLoading(WebView view, String url)
//            {
//                return false;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                // TODO Auto-generated method stub
//                super.onPageFinished(view, url);
//            }
//        });
//
//        dictAdapter = new FloatWordEfficientAdapter(mContext, DictEngine.getInstance());
//        listViewWord.setAdapter(dictAdapter);
//        listViewWord.setOnItemClickListener(mOnItemClickListener);
//
//        editText.addTextChangedListener(editTextWatcher);
//        editText.setOnEditorActionListener(editorActionListener);
//
//        //Set GUI
//        editText.setHint(GlobalData.dictShortName);
//        //Invisible at first
//        wordOption.setVisibility(View.GONE);
//        clearImg.setVisibility(View.GONE);
//
//        updateTTSControl();
//    }
//
//    public void updateDataChanged()
//    {
//        dictAdapter.notifyDataSetChanged();
//
//        //Set GUI
//        editText.setHint(GlobalData.dictShortName);
//        updateTTSControl();
//
//        if (GetCurrentView() != SEARCH_VIEW)
//        {
//            viewFlipper.setDisplayedChild(SEARCH_VIEW);
//            curView = SEARCH_VIEW;
//        }
//    }
//
//    void updateTTSControl()
//    {
//        if(TTS.getInstance().canSpeak())
//            speakerImg.setVisibility(View.VISIBLE);
//        else
//            speakerImg.setVisibility(View.GONE);
//    }
//
//    private WindowManager.LayoutParams buildLayoutParamsForMainView() {
//
//        Point sizeScreen = Util.getDisplaySize(mContext);
//        int screenW = sizeScreen.x;
//        int screenH = sizeScreen.y;
//
//        minWidth = (int)(MIN_POPUPSIZE_W*screenW);
//        minHeight = (int)(MIN_POPUPSIZE_H*screenH);
//
//        orgWidth = GlobalData.getPopUpSizeWidth(mContext);
//        orgHeight = GlobalData.getPopUpSizeHeight(mContext);
//        orgPosX = GlobalData.getPopUpPosX(mContext);
//        orgPosY = GlobalData.getPopUpPosY(mContext);
//
//        WindowManager.LayoutParams params;
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            params = new WindowManager.LayoutParams(
//                    orgWidth,
//                    orgHeight,
//                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
//                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
//                    PixelFormat.TRANSLUCENT);
//        } else {
//            params = new WindowManager.LayoutParams(
//                    orgWidth,
//                    orgHeight,
//                    WindowManager.LayoutParams.TYPE_PHONE,
//                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
//                    PixelFormat.TRANSLUCENT);
//        }
//
//        params.gravity = Gravity.TOP | Gravity.LEFT;
//        params.x = orgPosX;
//        params.y = orgPosY;
//        return params;
//    }
//
//    MoveFrameLayout.MoveResizeListener moveResizeListener = new MoveFrameLayout.MoveResizeListener() {
//        @Override
//        public void onTouchOutSide() {
//            if (quickViewSearchListener != null)
//                quickViewSearchListener.onQuickViewTouchOutside();
//        }
//
//        @Override
//        public void onMove(int offsetX, int offsetY) {
//            WindowManager.LayoutParams params = (WindowManager.LayoutParams) mainView.getLayoutParams();
//
//            params.x = orgPosX + offsetX;
//            params.y = orgPosY + offsetY;
//
//            windowManager.updateViewLayout(mainView, params);
//        }
//
//        @Override
//        public void onResize(int offsetX, int offsetY) {
//            WindowManager.LayoutParams params = (WindowManager.LayoutParams) mainView.getLayoutParams();
//
//            int width = orgWidth + offsetX;
//            int height = orgHeight + offsetY;
//
//            if (width < minWidth)
//                width = minWidth;
//            if (height < minHeight)
//                height = minHeight;
//
//            params.width = width;
//            params.height = height;
//
//            windowManager.updateViewLayout(mainView, params);
//        }
//
//        @Override
//        public void onStart() {
//            moveFrameView.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        public void onEnd() {
//            moveFrameView.setVisibility(View.INVISIBLE);
//
//            WindowManager.LayoutParams params = (WindowManager.LayoutParams) mainView.getLayoutParams();
//
//            orgPosX = params.x;
//            orgPosY = params.y;
//            orgWidth = params.width;
//            orgHeight = params.height;
//
//            updatePopUpInfo();
//        }
//    };
//
//    public void destroy()
//    {
//        if (mainView != null)
//            windowManager.removeView(mainView);
//    }
//
//    public void setOnQuickViewSearchListener(QuickViewSearchListener listener)
//    {
//        quickViewSearchListener = listener;
//    }
//
//    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
//        public void onItemClick(AdapterView arg0, View view, int position, long id) {
//            showMean(position);
//        }
//    };
//
//    private TextWatcher editTextWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            // TODO Auto-generated method stub
//            String textValue = s.toString();
//            if (textValue.isEmpty()) {
//                clearImg.setVisibility(View.GONE);
//                wordOption.setVisibility(View.GONE);
//            }
//            else {
//                clearImg.setVisibility(View.VISIBLE);
//            }
//            showWordListView();
//            int posWord = DictEngine.getInstance().OnEditSearch(textValue);
//            listViewWord.setSelection(posWord);
//        }
//    };
//
//    TextView.OnEditorActionListener editorActionListener = new TextView.OnEditorActionListener() {
//        @Override
//        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                String query = v.getText().toString().trim();
//                int posWord = DictEngine.getInstance().OnEditSearch(query);
//                String wordFind = DictEngine.getInstance().GetWord(posWord);
//                if (wordFind.compareToIgnoreCase(query) == 0)
//                    showMean(posWord);
//
//                return true;
//            }
//            return false;
//        }
//    };
//
//    void showMean(int index) {
//
//        hideEmulatorKeyboard();
//
//        wordOption.setVisibility(View.VISIBLE);
//
//        viewFlipper.setDisplayedChild(MEAN_VIEW);
//        curView = MEAN_VIEW;
//
//        word = DictEngine.getInstance().GetWord(index);
//        mean = HtmlConverter.String_htmlEncode(DictEngine.getInstance().GetMeanWord(index));
//
//        //DictDbHelper.getInstance().AddHistory(word, mean);
//
//        setWordMean(word, mean);
//
//    }
//
//    void showWordListView()
//    {
//        if (GetCurrentView() != SEARCH_VIEW)
//        {
//            viewFlipper.setDisplayedChild(SEARCH_VIEW);
//
//            curView = SEARCH_VIEW;
//        }
//    }
//
//    int GetCurrentView()
//    {
//        return viewFlipper.getDisplayedChild();
//    }
//
//    void setWordMean(String word, String mean)
//    {
//        final String MIMETYPE = "text/html";
//        final String ENCODING = "UTF-8";
//        if(DictDbHelper.getInstance().WordInFavorite(word))
//            favImg.setImageResource(R.drawable.ic_img_popup_fav);
//        else
//            favImg.setImageResource(R.drawable.ic_img_popup_nofav);
//
//        meanView.setFocusable(true); //remove keyboard
//
//        float zoomScale = GlobalData.getQSZoomScale(mContext)/100.0f;
//
//        meanView.loadDataWithBaseURL(null, HtmlConverter.update4ViewPort(mean, zoomScale),
//                MIMETYPE, ENCODING, "about:blank");
//    }
//
//    private View.OnClickListener imgClick = new View.OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//            // TODO Auto-generated method stub
//            switch (v.getId())
//            {
//                case R.id.imgFav:
//                    doFavorite();
//                    break;
//
//                case R.id.imgSpeaker:
//                    doSpeaker();
//                    break;
//
//                case R.id.imgClear:
//                    doEditClear();
//                    break;
//
////                case R.id.imgVoiceReg:
////                    doVoiceReg();
////                    break;
//            }
//        }
//    };
//
//
//    private void doFavorite()
//    {
//        if(DictDbHelper.getInstance().WordInFavorite(word))
//        {
//            favImg.setImageResource(R.drawable.ic_img_popup_nofav);
//            DictDbHelper.getInstance().RemoveFavorite(word);
//        }
//        else
//        {
//            favImg.setImageResource(R.drawable.ic_img_popup_fav);
//            DictDbHelper.getInstance().AddFavorite(word, mean);
//        }
//    }
//
//    private  void doSpeaker()
//    {
//        TTS.getInstance().speak(word);
//
////        final Context MyContext = mContext;
////        new Handler(Looper.getMainLooper()).post(new Runnable()
////        {
////            @Override
////            public void run()
////            {
////                Toast toast1 = Toast.makeText(MyContext, "Test doSpeaker", Toast.LENGTH_LONG);
////                toast1.show();
////            }
////        });
//
//
//    }
//
//    private void doEditClear()
//    {
//        editText.setText("");
//
//    }
//
//    /*
//        private void doVoiceReg()
//        {
//
//        }
//
//        private void promptSpeechInput() {
//
//            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//
//            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//
//            String locale = LangConst.langToLocale.get(Integer.valueOf(GlobalData.sourceLang));
//            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, locale);
//
//            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
//            try
//            {
//                startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
//            }
//            catch (Exception a)
//            {
//                Util.showErrorDlg(mContext, a.getMessage());
//            }
//        }
//    */
//    public void hideEmulatorKeyboard()
//    {
//        //Method 1
//        InputMethodManager inputManager = (InputMethodManager)mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
//        inputManager.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//    }
//
//    public void show(String word) {
//        show();
//        editText.setText(word);
//        int posWord = DictEngine.getInstance().OnEditSearch(word);
//
////        String wordFind = DictEngine.getInstance().GetWord(posWord);
////        if (wordFind.compareToIgnoreCase(word) == 0)
////            showMean(posWord);
//
//        showMean(posWord);//khong can kiem tra vi da kiem tra o ClipboardManager
//    }
//
//    public void show()
//    {
//        mainView.setVisibility(View.VISIBLE);
//
//        if (curView == MEAN_VIEW)
//        {
//            if(DictDbHelper.getInstance().WordInFavorite(word))
//                favImg.setImageResource(R.drawable.ic_img_popup_fav);
//            else
//                favImg.setImageResource(R.drawable.ic_img_popup_nofav);
//
//        }
////        //show user guide
////        Handler h = new Handler(mContext.getMainLooper());
////
////        h.post(new Runnable() {
////            @Override
////            public void run() {
////                showUserGuide();
////            }
////        });
//    }
//
//    public void hide()
//    {
//        mainView.setVisibility(View.GONE);
//    }
//
//    public void updatePopUpInfo()
//    {
//        GlobalData.setPopUpPosX(mContext, orgPosX);
//        GlobalData.setPopUpPosY(mContext, orgPosY);
//        GlobalData.setPopUpSizeWidth(mContext, orgWidth);
//        GlobalData.setPopUpSizeHeight(mContext, orgHeight);
//    }
//
//
//
//    public interface QuickViewSearchListener
//    {
//        public void onQuickViewTouchOutside();
//
//    }
//
//}
