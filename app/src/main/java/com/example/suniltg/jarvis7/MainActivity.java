package com.example.suniltg.jarvis7;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech myTTS;
    private String hh="Gooooood evening sir. I am at your service";
    private Button input;
    private AlarmManager alarmManager;
    int messageint=0;
    String messagereciever="";
    private final int MY_DATA_CHECK_CODE = 0;
    private Button btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private PowerManager mPowerManager;
    private PowerManager.WakeLock mWakeLock;
    String message333;
    int ack=0;
    public void turnOnScreen(){
        // turn on screen
        //PowerManager.WakeLock screenLock =    ((PowerManager)getSystemService(POWER_SERVICE)).newWakeLock(
         //       PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "TAG");
       // screenLock.acquire();

        //later
        //screenLock.release();
        Log.v("ProximityActivity", "ON!");
       // mWakeLock = mPowerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "tag");
        //mWakeLock.acquire();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(broadcastReceiver, new IntentFilter("Burr"));
        registerReceiver(broadcastReceiver, new IntentFilter("jrr"));
        registerReceiver(broadcastReceiver1, new IntentFilter("afafa"));
        /*MediaSession audioSession = new MediaSession(getApplicationContext(), "TAG");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            audioSession.setCallback(new MediaSession.Callback() {

                @Override
                public boolean onMediaButtonEvent(final Intent mediaButtonIntent) {
                    String intentAction = mediaButtonIntent.getAction();

                    if (Intent.ACTION_MEDIA_BUTTON.equals(intentAction))
                    {
                        KeyEvent event = (KeyEvent)mediaButtonIntent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
                        if (event != null)
                        {
                            int action = event.getAction();
                            if (action == KeyEvent.ACTION_DOWN) {
                                promptSpeechInput();


                            }
                            if (action == KeyEvent.ACTION_UP) {
                                long test = System.currentTimeMillis();


                            }
                        }

                    }
                    return super.onMediaButtonEvent(mediaButtonIntent);
                }
*


            });
        }*/

        startService(new Intent(getApplicationContext(),MyTell.class));
         alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

        input=(Button)findViewById(R.id.input);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnScreen();
                promptSpeechInput();
            }
        });
        Intent checkTTSIntent = new Intent();
       btnSpeak=(Button)findViewById(R.id.button);
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
        System.out.print("fafafaffffffffffffffff");

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sddd();
            }});}

    public void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "speech not supported",
                    Toast.LENGTH_SHORT).show();
        }
    }
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            promptSpeechInput();
            // internet lost alert dialog method call from here...
        }
    };
    BroadcastReceiver broadcastReceiver1=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            message333=getApplicationContext().getSharedPreferences("mypre",Context.MODE_PRIVATE).getString("messsss","message not proper");
            ack=1;
            long ssdd=System.currentTimeMillis();
            while (System.currentTimeMillis()<ssdd+7*1000)
            {

            }
            promptSpeechInput();
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Toast.makeText(getApplicationContext(), result.get(0), Toast.LENGTH_LONG).show();
                    String input = result.get(0);
                    if(ack==0){
                    if (messageint == 0) {
                        System.out.println("lkfjksdjfjdsfjkjfjsdjfsfksdkfk");
                       if(input.contains("Selena"))
                       {
                           System.out.println("lkfjksdjfjdsfjkjfjsdjfsfksdkfasfdsdfk");

                           myTTS.speak("I love u sunil forever and  forever",TextToSpeech.QUEUE_FLUSH,null);
                       }
                        else if (input.equals("Jarvis")) {
                            sdfs("Jarvis");
                        } else if (input.equals("condition")) {
                            sdfs("Condition");          } else if (input.substring(0, input.indexOf(" ")).equals("message")) {
                            String name = input.substring(input.indexOf(" ") + 1, input.length());
                            messageint = 1;
                            messagereciever = name;
                            getmessage(name);

                        }
                        else if(input.equals("set alarm"))
                        {
                            Calendar calendar=Calendar.getInstance();

                            //calendar.set(2016,11,30,12,43);
                            Toast.makeText(getApplicationContext(),""+calendar.getTimeInMillis(),Toast.LENGTH_LONG).show();
                           // long fsd=System.currentTimeMillis();
                            Intent intent =new Intent(this,AlarmReciever.class);
                            final PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
                            alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                        }
                        else {
                            System.out.println("entering ekse");
                            input = result.get(0);
                            int spaceindex = input.indexOf(" ");
                            String firstword = input.substring(0, spaceindex);
                            if (firstword.equals("message")) {
                                // int secondspace = input.indexOf(" ", spaceindex);
                                String secondword = input.substring(spaceindex + 1, input.length());
                                BackgroundWorker backgroundWorker = new BackgroundWorker(getApplicationContext());
                                backgroundWorker.execute(secondword);
                            } else {
                                for (int i = 0; i < result.size(); i++) {
                                    Toast.makeText(getApplicationContext(), "Sddddddddasdfaasd " + i + " " + result.get(i), Toast.LENGTH_LONG).show();
                                }
                                hh = "hi";
                                sddd();
                            }
                        }

                    } else {

                                System.out.println("smeaafs"+messagereciever+messageint);
                                BackgroundWorker backgroundWorker=new BackgroundWorker(getApplicationContext());
                        backgroundWorker.execute(messagereciever,input);
                        messagereciever="";
                        messageint=0;
                    }
                }
                    else
                    {
                        if(input.contains("yes"))
                        {
                            myTTS.speak(message333,TextToSpeech.QUEUE_FLUSH,null);
                        }
                        else
                        {
                            myTTS.speak("not reading the message sir",TextToSpeech.QUEUE_FLUSH,null);
                        }
                        ack=0;
                    }
                }
            }
                    break;
                    case MY_DATA_CHECK_CODE:
                        if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                            //the user has the necessary data - create the TTS
                            myTTS = new TextToSpeech(getApplicationContext(), this);
                            
                        } else {
                            //no data - install it now
                            Intent installTTSIntent = new Intent();
                            installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                            startActivity(installTTSIntent);
                        }
                        break;

                }


        }
    private void getmessage(String name) {
        speakWords("sir please spell the message you want to send to "+name);
        long time=System.currentTimeMillis();
        while(System.currentTimeMillis()<time+7*1000)
        {

        }
        promptSpeechInput();

    }

    private void sdfs(String h) {
        MediaPlayer mediaPlayer;
        switch (h) {
            case "Jarvis":
             mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.core);
                break;
            case "Condition":
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.condition);
                break;
            default:
                mediaPlayer=MediaPlayer.create(getApplicationContext(),RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));

        }
        mediaPlayer.start();
    }

    private void setAlarm(int timeHour,int timeMinute){
        Toast.makeText(getApplicationContext(),"setting alarm",Toast.LENGTH_LONG).show();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,12,25,22,22);
        System.out.println("hhhhhhhhhvvhhhhhhh"+calendar.getTimeInMillis());
        Toast.makeText(getApplicationContext(),"hvvhhhhhhh"+calendar.getTimeInMillis(),Toast.LENGTH_LONG).show();
        Intent intent =new Intent(this,AlarmReciever.class);
        PendingIntent p= PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_ONE_SHOT);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent, PendingIntent.FLAG_ONE_SHOT);
        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        long sd=1482685980000L;
        alarmManager.set(AlarmManager.RTC_WAKEUP,sd,pendingIntent);
    }
    private void sddd() {
        System.out.println("dfasssssssssssssssssssssssssssssssssssssss");
        speakWords(hh);
    }

    private void speakWords(String speech) {
            Toast.makeText(getApplicationContext(),"fafasf",Toast.LENGTH_LONG).show();

            myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }


    //setup TTS
    public void onInit(int initStatus) {

        //check for successful instantiation
        if (initStatus == TextToSpeech.SUCCESS) {
            if(myTTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE) {
                Toast.makeText(getApplicationContext(), "sfassssssssssss", Toast.LENGTH_LONG).show();

                myTTS.setLanguage(Locale.US);
            }
            }
        else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }


}
