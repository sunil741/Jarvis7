package com.example.suniltg.jarvis7;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.preference.Preference;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by sunil TG on 12/28/2016.
 */
public class Butt extends Service  {
    public Butt() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
      /*  mPreferences = getSharedPreferences(EnvironmentalReverb.Settings.PREF_NAME, Service.MODE_PRIVATE);

        pit = Float.parseFloat(mPreferences.getString("pit","0.8"));
        rate = Float.parseFloat(mPreferences.getString("rate","1.1"));*/
        sendBroadcast(new Intent("jrr"));

        super.onStart(intent, startId);
    }


}