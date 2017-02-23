package com.example.suniltg.jarvis7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private TextView enter;
    private EditText name;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ((AudioManager)getSystemService(AUDIO_SERVICE)).registerMediaButtonEventReceiver(
                new ComponentName(
                        getPackageName(),
                        MediaButtonIntentReceiver.class.getName()));
        SharedPreferences sharedPref = getSharedPreferences("mypre",Context.MODE_PRIVATE);
        String name2 = sharedPref.getString("name","sdsfsadfadsfafa");
        if (name2.equals("sdsfsadfadsfafa")) {
            enter = (TextView) findViewById(R.id.textView2);
            name = (EditText) findViewById(R.id.editText);
            button = (Button) findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name1 = name.getText().toString();
                    SharedPreferences sharedPref = getSharedPreferences("mypre",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("name", name1);
                    editor.commit();
                    SharedPreferences sharedPref1 = getSharedPreferences("mypre",Context.MODE_PRIVATE);
                    String token = sharedPref1.getString("token","sdsfsadfadsfafa");
                    if (token.equals("sdsfsadfadsfafa")) {
                        Toast.makeText(getApplicationContext(),"please swithch on the network",Toast.LENGTH_LONG).show();
                    }
                    else {

                        BackgroundWorker2 back=new BackgroundWorker2(getApplicationContext());
                        back.execute();
                        startActivity(new Intent(Main2Activity.this, MainActivity.class));
                    }
                }
            });

        }
        else
        {
            startActivity(new Intent(Main2Activity.this, MainActivity.class));
        }
    }
}