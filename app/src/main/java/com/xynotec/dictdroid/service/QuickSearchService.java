//package com.xynotec.dictdroid.service;
//
//import android.app.Notification;
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.ClipData;
//import android.content.ClipboardManager;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Build;
//import android.os.Handler;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
////import android.support.v7.app.NotificationCompat;
//import android.support.v4.app.NotificationCompat;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.WindowManager;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//
//import com.xynotec.dictdroid.ende.BuildConfig;
//import com.xynotec.dictdroid.ende.R;
//import com.xynotec.dictdroid.MainApplication;
//import com.xynotec.dictdroid.data.GlobalData;
//import com.xynotec.dictdroid.engine.DictEngine;
//import com.xynotec.dictdroid.floatview.BubbleView;
//import com.xynotec.dictdroid.floatview.QuickSearchView;
//import com.xynotec.dictdroid.ende.MainActivity;
//import com.xynotec.util.Util;
//
///**
// * Created by Danh Phan on 9/21/2016.
// */
//public class QuickSearchService extends Service{
//
//    public final static int QS_ACTION_UNKNOWN = -1;
//    public final static int QS_ACTION_QUICK_SEARCH = 0;
//    public final static int QS_ACTION_REGISTER_CLIPBOARD = 1;
//    public final static int QS_ACTION_UNREGISTER_CLIPBOARD = 2;
//    public final static int QS_ACTION_UPDATE_DATA = 3;
//
//    private boolean mRegistered = false;
//    private String mLastWord;
//    private long mTimestamp = 0;
//
//    ///////////////////////////////////////////////////
//    public static final String QUICK_SEARCH_STATE = "qsearchstate";
//
//    private BubbleView bubbleView;
//    private QuickSearchView quickSearchView;
//
//    static boolean bRunning = false;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        Log.d("QuickSearchService", "onCreate");
//
//        bubbleView = new BubbleView(this);
//        bubbleView.setOnBubbleViewListener(bubbleViewListener);
//        bubbleView.hide();//not show at first
//
//        quickSearchView = new QuickSearchView(this);
//        quickSearchView.setOnQuickViewSearchListener(quickViewSearchListener);
//        quickSearchView.hide();
//
//        bRunning = true;
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//
//        //super.onStartCommand(intent, flags, startId);
//        int searchAction = intent.getIntExtra(QUICK_SEARCH_STATE, QS_ACTION_UNKNOWN);
//
//        switch (searchAction)
//        {
//            case QS_ACTION_QUICK_SEARCH:
//                Log.d("QuickSearchService", "onStartCommand-----------------QUICK_SEARCH");
//                bubbleView.hide();
//                quickSearchView.show();
//                break;
//
//            case QS_ACTION_REGISTER_CLIPBOARD:
//                Log.d("QuickSearchService", "onStartCommand-----------------REGISTER_CLIPBOARD");
//                registerClipboardListener();
//                showNotification();
//                break;
//
//            case QS_ACTION_UNREGISTER_CLIPBOARD:
//                Log.d("QuickSearchService", "onStartCommand-----------------UNREGISTER_CLIPBOARD");
//                unRegisterClipboardListener();
//                stopForeground(true);
//                stopSelf();
//                break;
//
//            case QS_ACTION_UPDATE_DATA:
//                Log.d("QuickSearchService", "onStartCommand-----------------QS_ACTION_UPDATE_DATA");
//                bubbleView.updateDataChanged();
//                quickSearchView.updateDataChanged();
//                break;
//        }
//
//        return START_REDELIVER_INTENT;
//    }
//
//    BubbleView.BubbleViewListener bubbleViewListener = new BubbleView.BubbleViewListener() {
//        @Override
//        public void onBubbleClick() {
//            bubbleView.hide();
//
//            quickSearchView.show();
//        }
//
//        @Override
//        public void onBubbleTrash() {
//            bubbleView.hide(true);
//        }
//    };
//
//    QuickSearchView.QuickViewSearchListener quickViewSearchListener = new QuickSearchView.QuickViewSearchListener() {
//        @Override
//        public void onQuickViewTouchOutside() {
//            quickSearchView.hide();
//            bubbleView.show();
//        }
//    };
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//
//        Log.d("QuickSearchService", "onDestroy");
//
//        if (bubbleView != null)
//        {
//            bubbleView.destroy();
//            bubbleView = null;
//        }
//
//        if (quickSearchView != null)
//        {
//            quickSearchView.destroy();
//            quickSearchView = null;
//        }
//
//        bRunning = false;
//    }
//
//    public static boolean isRunning()
//    {
//        return bRunning;
//    }
//
//    final static int PERIOD = 5*1000;
//    Handler handler = new Handler();
//    Runnable runnable = new Runnable(){
//
//        @Override
//        public void run() {
//            // TODO Auto-generated method stub
//            Log.d("QuickSearchService", "Run -----------------n times");
//            handler.postDelayed(this, PERIOD);
//        }
//    };
//
//    private void registerClipboardListener()
//    {
//        Log.d("QuickSearchService", "Begin++++++++++++++++++++++registerClipboardListener");
//        if (!mRegistered) {
//            if (BuildConfig.DEBUG)
//                handler.post(runnable);
//
//            synchronized (mClipListener) {
//                ClipboardManager clipboardManager =
//                        (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//                clipboardManager.addPrimaryClipChangedListener(mClipListener);
//                mRegistered = true;
//
//                GlobalData.setAutoLookup(this, true);
//            }
//            Log.d("QuickSearchService", "++++++++++++++++++++++registerClipboardListener");
//        }
//    }
//
//    private void unRegisterClipboardListener()
//    {
//        Log.d("QuickSearchService", "Begin++++++++++++++++++++++unRegisterClipboardListener");
//
//        if (mRegistered) {
//            if (BuildConfig.DEBUG)
//                handler.removeCallbacks(runnable);
//
//            ClipboardManager clipboardManager =
//                    (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//            clipboardManager.removePrimaryClipChangedListener(mClipListener);
//            mRegistered = false;
//
//            GlobalData.setAutoLookup(this, false);
//            Log.d("QuickSearchService", "++++++++++++++++++++++unRegisterClipboardListener");
//        }
//    }
//
//    ClipboardManager.OnPrimaryClipChangedListener mClipListener =
//            new ClipboardManager.OnPrimaryClipChangedListener() {
//                @Override
//                public void onPrimaryClipChanged() {
//                    Log.d("CBMonitorService", "Begin onPrimaryClipChanged");
//
//                    final ClipboardManager clipboard =
//                            (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//                    ClipData data = clipboard.getPrimaryClip();
//                    if (data == null) {
//                        return;
//                    }
//
//                    String text = extractTextFromClipData(data);
//
//                    Log.d("CBMonitorService", "extractTextFromClipData: " + text);
//
//                    if (text != null) {
//                        text = text.trim();
//                    }
//
//                    if (!TextUtils.isEmpty(text) && !isDuplicated(text)) {
//                        mLastWord = text;
//                        mTimestamp = System.currentTimeMillis();
//
//                        Log.d("CBMonitorService", "QuickSearchService.show: " + text);
//
//                        int posWord = DictEngine.getInstance().OnEditSearch(text);
//                        String wordFind = DictEngine.getInstance().GetWord(posWord);
//                        if (wordFind.compareToIgnoreCase(text) == 0) {
//                            bubbleView.hide();
//                            quickSearchView.show(wordFind);
//                        }
//                    }
//                }
//
//                // To tackle with the funny behaviour of clipboard listener
//                private boolean isDuplicated(String text) {
//                    return text.equals(mLastWord) && System.currentTimeMillis() - mTimestamp < 1000;
//                }
//
//                private String extractTextFromClipData(ClipData clipData)
//                {
//                    if (clipData == null) {
//                        return null;
//                    }
//
//                    ClipData.Item item = clipData.getItemAt(0);
//                    if (item == null) {
//                        return null;
//                    }
//
//                    CharSequence text = item.getText();
//                    if (text != null)
//                        return text.toString();
//
//                    return null;
//                }
//            };
//
//
//    public static int FOREGROUND_SERVICE = 101;
//
//    private void showNotification() {
//        Intent notificationIntent = new Intent(this, MainActivity.class);
//        //notificationIntent.setAction(MAIN_ACTION);
//        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
//                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
//
//        Intent turnOffIntent = new Intent(this, QuickSearchService.class);
//        turnOffIntent.putExtra(QUICK_SEARCH_STATE, QS_ACTION_UNREGISTER_CLIPBOARD);
//        PendingIntent pTurnOffIntent = PendingIntent.getService(this, 0,turnOffIntent, 0);
//
//        Bitmap icon = BitmapFactory.decodeResource(getResources(),
//                    R.mipmap.ic_launcher);
//
//        String channelID = getNotificationChannelID();
//        Notification notification = new NotificationCompat.Builder(this, channelID)
//                .setContentTitle(getString(R.string.app_name))
//                .setTicker(getString(R.string.app_name))
//                .setContentText(getString(R.string.clipboard_is_active))
//                .setSmallIcon(getNotificationIcon())
//                .setLargeIcon(Bitmap.createScaledBitmap(icon, 128, 128, false))
//                .setContentIntent(pendingIntent)
//                .setOngoing(true)
//                .addAction(R.drawable.ic_img_popup_clear, getString(R.string.clipboard_turn_off),
//                        pTurnOffIntent).build();
//
//        startForeground(FOREGROUND_SERVICE, notification);
//    }
//
//    private int getNotificationIcon() {
//        boolean useWhiteIcon = (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP);
//        return useWhiteIcon ? R.drawable.ic_notification : R.mipmap.ic_launcher;
//    }
//
//    private String getNotificationChannelID() {
//        final String channelID = "GoalieChannelID";
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationManager mNotificationManager =
//                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//            CharSequence name = getString(R.string.app_name);
//            String description = getString(R.string.channel_description);
//            int importance = NotificationManager.IMPORTANCE_HIGH;
//
//            NotificationChannel mChannel = new NotificationChannel(channelID, name, importance);
//            mChannel.setDescription(description);
//            mChannel.enableLights(true);
//            mChannel.enableVibration(true);
//            mNotificationManager.createNotificationChannel(mChannel);
//        }
//
//        return channelID;
//    }
//
//}
