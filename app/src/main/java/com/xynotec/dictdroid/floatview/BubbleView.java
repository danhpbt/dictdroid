//package com.xynotec.dictdroid.floatview;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.PixelFormat;
//import android.graphics.Point;
//import android.os.CountDownTimer;
//import android.os.Handler;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.xynotec.dictdroid.ende.R;
//import com.xynotec.dictdroid.data.GlobalData;
//import com.xynotec.util.Util;
//
///**
// * Created by Danh Phan on 9/21/2016.
// */
//public class BubbleView {
//
//    BubbleViewListener bubbleViewListener;
//
//    final int BOUNCE_TIMER = 1000;
//    final float TRASH_ZOOM_SCALE = 1.25f;
//    Context mContext;
//    WindowManager windowManager;
//
//    FrameLayout viewBubble;
//    RelativeLayout viewTrash;
//
//    //WindowManager.LayoutParams paramsBubble;
//    //WindowManager.LayoutParams paramsTrash;
//
//    TextView  tv_DictName;
//    ImageView imgBubble;
//    ImageView imgTrash;
//
//    private boolean isLeft = true;
//    private Point szWindow = new Point();
//
//    public BubbleView(Context context)
//    {
//        mContext = context;
//        windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
//        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        viewBubble = (FrameLayout)inflater.inflate(R.layout.bubble_head, null);
//        viewTrash = (RelativeLayout)inflater.inflate(R.layout.bubble_trash, null);
//
//        tv_DictName = (TextView) viewBubble.findViewById(R.id.tv_dict_name);
//        imgBubble = (ImageView) viewBubble.findViewById(R.id.bubblehead_img);
//        imgTrash = (ImageView) viewTrash.findViewById(R.id.trash_img);
//
//        WindowManager.LayoutParams paramsBubble = buildLayoutParamsForBubble();
//        WindowManager.LayoutParams paramsTrash = buildLayoutParamsForTrash();
//
//        windowManager.addView(viewBubble, paramsBubble);
//        windowManager.addView(viewTrash, paramsTrash);
//
//        //Init first view
//        szWindow = Util.getDisplaySize(mContext);
//        String dictName = GlobalData.dictShortName.substring(0, 5);
//        tv_DictName.setText(dictName);
//
//        imgBubble.setAlpha(0.5f);
//        tv_DictName.setAlpha(0.5f);
//        viewBubble.setOnTouchListener(bubbleTouchListener);
//        viewTrash.setVisibility(View.GONE);
//
//    }
//
//    public void setOnBubbleViewListener(BubbleViewListener listener)
//    {
//        bubbleViewListener = listener;
//    }
//
//    public void destroy()
//    {
//        if(viewBubble!= null){
//            windowManager.removeView(viewBubble);
//        }
//
//        if(viewTrash != null){
//            windowManager.removeView(viewTrash);
//        }
//    }
//
//    public void show()
//    {
//        viewBubble.setVisibility(View.VISIBLE);
//        viewTrash.setVisibility(View.GONE);
//    }
//
//    public void hide()
//    {
//        viewBubble.setVisibility(View.GONE);
//        viewTrash.setVisibility(View.GONE);
//    }
//
//    public void hide(boolean bOriginPos)
//    {
//        hide();
//        if (bOriginPos)
//        {
//            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) viewBubble.getLayoutParams();
//            layoutParams.x = 0;
//            layoutParams.y = GlobalData.getPopUpPosY(mContext);
//            windowManager.updateViewLayout(viewBubble, layoutParams);
//        }
//    }
//
//    public void updateDataChanged()
//    {
//        String dictName = GlobalData.dictShortName.substring(0, 5);
//        tv_DictName.setText(dictName);
//    }
//
//    private WindowManager.LayoutParams buildLayoutParamsForBubble() {
//        int x = 0;
//        int y = GlobalData.getPopUpPosY(mContext);
//
//        WindowManager.LayoutParams params;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            params = new WindowManager.LayoutParams(
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
//                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                    PixelFormat.TRANSLUCENT);
//        } else {
//            params = new WindowManager.LayoutParams(
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.TYPE_PHONE,
//                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                    PixelFormat.TRANSLUCENT);
//        }
//
//        params.gravity = Gravity.TOP | Gravity.LEFT;
//        params.x = x;
//        params.y = y;
//        return params;
//    }
//
//    private WindowManager.LayoutParams buildLayoutParamsForTrash() {
//        int x = 0;
//        int y = 0;
//        WindowManager.LayoutParams params;
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            params = new WindowManager.LayoutParams(
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
//                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                    PixelFormat.TRANSPARENT);
//        } else {
//            params = new WindowManager.LayoutParams(
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.TYPE_PHONE,
//                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                    PixelFormat.TRANSPARENT);
//        }
//        params.gravity = Gravity.TOP | Gravity.LEFT;
//        return params;
//    }
//
//    View.OnTouchListener bubbleTouchListener = new View.OnTouchListener() {
//        int x_init_cord, y_init_cord, x_init_margin, y_init_margin;
//
//        long time_start = 0, time_end = 0;
//        boolean isLongclick = false, inBounded = false;
//        int remove_img_width = 0, remove_img_height = 0;
//
//        Handler handler_longClick = new Handler();
//        Runnable runnable_longClick = new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                Log.d("BubbleView", "Into runnable_longClick");
//
//                isLongclick = true;
//                viewTrash.setVisibility(View.VISIBLE);
//                chathead_longclick();
//            }
//        };
//
//
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) viewBubble.getLayoutParams();
//
//            int x_cord = (int) event.getRawX();
//            int y_cord = (int) event.getRawY();
//            int x_cord_Destination, y_cord_Destination;
//
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    time_start = System.currentTimeMillis();
//                    handler_longClick.postDelayed(runnable_longClick, 600);
//
//                    remove_img_width = imgTrash.getLayoutParams().width;
//                    remove_img_height = imgTrash.getLayoutParams().height;
//
//                    x_init_cord = x_cord;
//                    y_init_cord = y_cord;
//
//                    x_init_margin = layoutParams.x;
//                    y_init_margin = layoutParams.y;
//                    break;
//
//                case MotionEvent.ACTION_MOVE:
//                    imgBubble.setAlpha(1.0f);
//                    tv_DictName.setAlpha(1.0f);
//
//                    int x_diff_move = x_cord - x_init_cord;
//                    int y_diff_move = y_cord - y_init_cord;
//
//                    x_cord_Destination = x_init_margin + x_diff_move;
//                    y_cord_Destination = y_init_margin + y_diff_move;
//
//                    if(isLongclick){
//                        int x_bound_left = szWindow.x / 2 - (int)(remove_img_width * TRASH_ZOOM_SCALE);
//                        int x_bound_right = szWindow.x / 2 +  (int)(remove_img_width * TRASH_ZOOM_SCALE);
//                        int y_bound_top = szWindow.y - (int)(remove_img_height * TRASH_ZOOM_SCALE);
//
//                        if((x_cord >= x_bound_left && x_cord <= x_bound_right) && y_cord >= y_bound_top){
//                            inBounded = true;
//
//                            int x_cord_remove = (int) ((szWindow.x - (remove_img_width * TRASH_ZOOM_SCALE)) / 2);
//                            int y_cord_remove = (int) (szWindow.y - ((remove_img_height * TRASH_ZOOM_SCALE) + getStatusBarHeight() ));
//
//                            if(imgTrash.getLayoutParams().height == remove_img_height){
//                                imgTrash.getLayoutParams().height = (int) (remove_img_height * TRASH_ZOOM_SCALE);
//                                imgTrash.getLayoutParams().width = (int) (remove_img_width * TRASH_ZOOM_SCALE);
//
//                                WindowManager.LayoutParams param_remove = (WindowManager.LayoutParams) viewTrash.getLayoutParams();
//                                param_remove.x = x_cord_remove;
//                                param_remove.y = y_cord_remove;
//
//                                windowManager.updateViewLayout(viewTrash, param_remove);
//                            }
//
//                            layoutParams.x = x_cord_remove + (Math.abs(viewTrash.getWidth() - viewBubble.getWidth())) / 2;
//                            layoutParams.y = y_cord_remove + (Math.abs(viewTrash.getHeight() - viewBubble.getHeight())) / 2 ;
//
//                            windowManager.updateViewLayout(viewBubble, layoutParams);
//                            break;
//                        }else{
//                            inBounded = false;
//                            imgTrash.getLayoutParams().height = remove_img_height;
//                            imgTrash.getLayoutParams().width = remove_img_width;
//
//                            WindowManager.LayoutParams param_remove = (WindowManager.LayoutParams) viewTrash.getLayoutParams();
//                            int x_cord_remove = (szWindow.x - viewTrash.getWidth()) / 2;
//                            int y_cord_remove = szWindow.y - (viewTrash.getHeight() + getStatusBarHeight() );
//
//                            param_remove.x = x_cord_remove;
//                            param_remove.y = y_cord_remove;
//
//                            windowManager.updateViewLayout(viewTrash, param_remove);
//                        }
//
//                    }
//
//
//                    layoutParams.x = x_cord_Destination;
//                    layoutParams.y = y_cord_Destination;
//
//                    windowManager.updateViewLayout(viewBubble, layoutParams);
//                    break;
//
//                case MotionEvent.ACTION_UP:
//                    imgBubble.setAlpha(0.5f);
//                    tv_DictName.setAlpha(0.5f);
//
//                    isLongclick = false;
//                    viewTrash.setVisibility(View.GONE);
//                    imgTrash.getLayoutParams().height = remove_img_height;
//                    imgTrash.getLayoutParams().width = remove_img_width;
//
//                    handler_longClick.removeCallbacks(runnable_longClick);
//
//                    if(inBounded){
//                        //mContext.stopService(new Intent(mContext, QuickSearchService.class));
//
//                        if (bubbleViewListener != null)
//                            bubbleViewListener.onBubbleTrash();
//                        inBounded = false;
//                        break;
//                    }
//                    int x_diff = x_cord - x_init_cord;
//                    int y_diff = y_cord - y_init_cord;
//
//                    if(Math.abs(x_diff) < 5 && Math.abs(y_diff) < 5){
//                        time_end = System.currentTimeMillis();
//                        if((time_end - time_start) < 300){
//                            //chathead_click();
//
//                            if (bubbleViewListener != null)
//                                bubbleViewListener.onBubbleClick();
//                        }
//                    }
//
//                    y_cord_Destination = y_init_margin + y_diff;
//
//                    int BarHeight =  getStatusBarHeight();
//                    if (y_cord_Destination < 0) {
//                        y_cord_Destination = 0;
//                    } else if (y_cord_Destination + (viewBubble.getHeight() + BarHeight) > szWindow.y) {
//                        y_cord_Destination = szWindow.y - (viewBubble.getHeight() + BarHeight );
//                    }
//                    layoutParams.y = y_cord_Destination;
//
//                    inBounded = false;
//                    resetPosition(x_cord);
//
//                    break;
//                default:
//                    break;
//            }
//            return true;
//        }
//    };
//
//
//    private void chathead_click(){
//        Log.d("BubbleView", "chatheadView.setOnTouchListener  -> event.getAction() : default");
//    }
//
//
//    private void resetPosition(int x_cord_now) {
//        if(x_cord_now <= szWindow.x / 2){
//            isLeft = true;
//            moveToLeft(x_cord_now);
//
//        } else {
//            isLeft = false;
//            moveToRight(x_cord_now);
//
//        }
//
//    }
//    private void moveToLeft(final int x_cord_now){
//        final int x = szWindow.x - x_cord_now;
//
//        new CountDownTimer(BOUNCE_TIMER, 5) {
//            WindowManager.LayoutParams mParams = (WindowManager.LayoutParams) viewBubble.getLayoutParams();
//            public void onTick(long t) {
//                long step = (BOUNCE_TIMER - t)/5;
//                mParams.x = 0 - (int)(double)bounceValue(step, x );
//                windowManager.updateViewLayout(viewBubble, mParams);
//            }
//            public void onFinish() {
//                mParams.x = 0;
//                windowManager.updateViewLayout(viewBubble, mParams);
//            }
//        }.start();
//    }
//    private  void moveToRight(final int x_cord_now){
//        new CountDownTimer(BOUNCE_TIMER, 5) {
//            WindowManager.LayoutParams mParams = (WindowManager.LayoutParams) viewBubble.getLayoutParams();
//            public void onTick(long t) {
//                long step = (BOUNCE_TIMER - t)/5;
//                mParams.x = szWindow.x + (int)(double)bounceValue(step, x_cord_now) - viewBubble.getWidth();
//                windowManager.updateViewLayout(viewBubble, mParams);
//            }
//            public void onFinish() {
//                mParams.x = szWindow.x - viewBubble.getWidth();
//                windowManager.updateViewLayout(viewBubble, mParams);
//            }
//        }.start();
//    }
//
//    private double bounceValue(long step, long scale){
//        double value = scale * java.lang.Math.exp(-0.055 * step) * java.lang.Math.cos(0.08 * step);
//        return value;
//    }
//
//
//    private int getStatusBarHeight() {
//        int statusBarHeight = (int) Math.ceil(25 * mContext.getResources().getDisplayMetrics().density);
//        return statusBarHeight;
//    }
//
//    private void chathead_longclick(){
//        Log.d("BubbleView", "Into ChatHeadService.chathead_longclick() ");
//
//        WindowManager.LayoutParams param_remove = (WindowManager.LayoutParams) viewTrash.getLayoutParams();
//        int x_cord_remove = (szWindow.x - viewTrash.getWidth()) / 2;
//        int y_cord_remove = szWindow.y - (viewTrash.getHeight() + getStatusBarHeight() );
//
//        param_remove.x = x_cord_remove;
//        param_remove.y = y_cord_remove;
//
//        windowManager.updateViewLayout(viewTrash, param_remove);
//    }
//
//    public interface BubbleViewListener
//    {
//        public void onBubbleClick();
//        public void onBubbleTrash();
//    }
//
//
//}
