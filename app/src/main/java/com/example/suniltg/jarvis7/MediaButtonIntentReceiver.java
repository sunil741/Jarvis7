package com.example.suniltg.jarvis7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by sunil TG on 12/28/2016.
 */
public class MediaButtonIntentReceiver extends BroadcastReceiver {

    public MediaButtonIntentReceiver() {
        super();
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        System.out.print("eeeeeeeeeeeeeeeeee");
        if ((!Intent.ACTION_MEDIA_BUTTON.equals(intentAction))){
            return;
        }

        KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if (event == null) {
            return;
        }
        int action = event.getAction();
        if (action == KeyEvent.ACTION_DOWN) {
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                    "MyWakelockTag");
            wakeLock.acquire();
            // do something
            System.out.print("ed3eeessssssssssssssssssssssssssssssssssssss");
            Toast.makeText(context, "BUTTON PRESSED!", Toast.LENGTH_SHORT).show();
            context.sendBroadcast(new Intent("Burr"));

        }

    }

}