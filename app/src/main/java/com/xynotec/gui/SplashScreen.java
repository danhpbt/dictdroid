package com.xynotec.gui;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.xynotec.dictdroid.data.GlobalData;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ui.login.LoginActivity;
import com.xynotec.dictdroid.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;
//import com.xynotec.dictdroid.data.GlobalData;

public class SplashScreen extends AppCompatActivity
{   
	final static int SPLASH_TIME = 500;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.xynotec_splash);

		TypedValue a = new TypedValue();
		getTheme().resolveAttribute(android.R.attr.windowBackground, a, true);
		if (a.type >= TypedValue.TYPE_FIRST_COLOR_INT && a.type <= TypedValue.TYPE_LAST_COLOR_INT)
		{
			GlobalData.colorBackground = String.format("#%06X", (0xFFFFFF & a.data));
		}

		new Handler().postDelayed(new Runnable() {
        	 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
            	Intent i = new Intent(SplashScreen.this, MainActivity.class);
				//Intent i = new Intent(SplashScreen.this, LoginActivity.class);
				startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME);

	}

}

