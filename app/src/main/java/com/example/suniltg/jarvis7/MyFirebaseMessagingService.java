package com.example.suniltg.jarvis7;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Locale;


/**
 * Created by sunil TG on 12/27/2016.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        System.out.println("fsdfkkkfkkskkdkfkafksakkalkas");
        super.onMessageReceived(remoteMessage);
        startService(new Intent(getApplicationContext(),MyTell.class));

        String message = remoteMessage.getData().get("message").toString();
        String from=remoteMessage.getData().get("from2").toString();

        System.out.println("dsfafafadfafaweeqwqq" + message);
        MyTell.mTts.speak("Sir you have an incoming message from "+from+" Would u like me to read it for you", TextToSpeech.QUEUE_FLUSH,null);
        SharedPreferences sharedPref=getApplicationContext().getSharedPreferences("mypre", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("messsss",message );
        editor.commit();
        sendBroadcast(new Intent("afafa"));
       // Toast.makeText(getApplicationContext(),message+" from "+from,Toast.LENGTH_LONG).show();
        // startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);


        // if (remoteMessage.getNotification().getBody().equals("alarm")) {
      /*  AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReciever.class);
        //PendingIntent p= PendingIntent.getActivity(v.getContext(),0,intent,PendingIntent.FLAG_ONE_SHOT);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000 * 5, pendingIntent);
        System.out.println("fsdfkkkfkkskkdkfkafksakkalkas");*/

    }
}
//    else Toast.makeText(this,"wrong text",Toast.LENGTH_LONG).show();
//}