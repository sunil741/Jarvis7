package com.example.suniltg.jarvis7;

import android.app.Service;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.media.audiofx.EnvironmentalReverb;
import android.os.IBinder;
import android.preference.Preference;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by sunil TG on 12/27/2016.
 */
public class MyTell extends Service implements TextToSpeech.OnInitListener {
    public MyTell() {
    }

    public static TextToSpeech mTts;
    Preference mPreferences;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
      /*  mPreferences = getSharedPreferences(EnvironmentalReverb.Settings.PREF_NAME, Service.MODE_PRIVATE);

        pit = Float.parseFloat(mPreferences.getString("pit","0.8"));
        rate = Float.parseFloat(mPreferences.getString("rate","1.1"));*/
        mTts = new TextToSpeech(this, this);
        super.onStart(intent, startId);
    }

    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {
            if (mTts.isLanguageAvailable(Locale.US) >= 0)

                Toast.makeText( MyTell.this,
                        "Sucessfull intialization of Text-To-Speech engine Mytell ",
                        Toast.LENGTH_LONG).show();
            mTts.setLanguage(Locale.UK);

            mTts.setPitch(180);
            mTts.setSpeechRate(1);

        } else if (status == TextToSpeech.ERROR) {
            Toast.makeText(MyTell.this,
                    "Unable to initialize Text-To-Speech engine",
                    Toast.LENGTH_LONG).show();
        }
    }}