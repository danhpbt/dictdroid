package com.xynotec.common;

import android.content.Context;
import android.media.AudioManager;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

import javax.inject.Inject;

public final class TTS {

    private static final String TAG = "TTS";

    private Locale mLocale = new Locale("en", "US");
    private TextToSpeech mTextToSpeech;
    private boolean bSupportTTS = false;
    private Context mContext;

    public TTS(Context context)
    {
        Log.d(TAG, "TTS: InitTextToSpeech");

        mContext = context;
        mTextToSpeech = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                Log.d(TAG, "onInit: Status " + status);

                if (status == TextToSpeech.SUCCESS)
                    setTTSLanguage(mLocale);

                Log.d("TTS", "SupportTTS: " + bSupportTTS);
            }
        });

    }

    public boolean isSupportTTS()
    {
        return bSupportTTS;
    }

    public void setTTSLanguage(Locale locale)
    {
        bSupportTTS = false;
        if (mTextToSpeech != null)
        {
            int result = TextToSpeech.ERROR;

            if (locale != null)
                result  = mTextToSpeech.setLanguage(locale);

            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED ||
                    result == TextToSpeech.ERROR)
                bSupportTTS = false;
            else
                bSupportTTS = true;
        }

    }

    public void speak(String word)
    {
        if (mTextToSpeech != null && !mTextToSpeech.isSpeaking())
        {
            AudioManager am = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
            mTextToSpeech.speak(word, TextToSpeech.QUEUE_ADD, null);

            //get volume by volume key
//            int curVol = am.getStreamVolume(am.STREAM_RING);
//            int maxVol = am.getStreamMaxVolume(am.STREAM_MUSIC);
//            am.setStreamVolume(am.STREAM_MUSIC, maxVol, 0);
//            mTextToSpeech.speak(word, TextToSpeech.QUEUE_ADD, null);
//            am.setStreamVolume(am.STREAM_MUSIC, curVol, 0);
        }
    }

    public void close()
    {
        if (mTextToSpeech != null)
        {
            mTextToSpeech.stop();
            mTextToSpeech.shutdown();
            mTextToSpeech = null;
        }
    }
}
