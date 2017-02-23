package com.example.suniltg.jarvis7;

/**
 * Created by sunil TG on 12/25/2016.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

import static android.media.RingtoneManager.TYPE_ALARM;

/**
 * Created by PERSONAL on 06-08-2016.
 */
public class AlarmReciever extends BroadcastReceiver {
    Context context;

    @Override

    public void onReceive(Context context, Intent intent) {
        this.context=context;

        //MyTell.mTts.speak("Sir u have set an alarm time for u to wake up", TextToSpeech.QUEUE_FLUSH,null);

        MediaPlayer mediaPlayer=  MediaPlayer.create(context,R.raw.condition);
        mediaPlayer.start();
    }


}
