package com.example.suniltg.jarvis7;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ttsact extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech myTTS;
    private final int MY_DATA_CHECK_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttsact);

        String message=getIntent().getStringExtra("message");
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
        myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                    //the user has the necessary data - create the TTS
                    myTTS = new TextToSpeech(getApplicationContext(), this);
                }
                else {
                    //no data - install it now
                    Intent installTTSIntent = new Intent();
                    installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                    startActivity(installTTSIntent);
                }


        }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            if(myTTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE) {
                Toast.makeText(getApplicationContext(), "sfassssssssssss", Toast.LENGTH_LONG).show();

                myTTS.setLanguage(Locale.US);
            }
        }
        else if (status == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }
    }



