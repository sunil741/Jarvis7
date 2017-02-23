package com.example.suniltg.jarvis7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * Created by sunil TG on 12/28/2016.
 */
public class Buurrr extends BroadcastReceiver {

    public Buurrr() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        System.out.print("eeeeeeeeeeeeeeeeee");
        if (!(intent.getAction().equals("jrr"))){
            return;
        }


    }
}