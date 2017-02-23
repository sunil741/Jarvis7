package com.example.suniltg.jarvis7;

/**
 * Created by sunil TG on 12/26/2016.
 */
public class daffa {
         /*for (Locale locale : Locale.getAvailableLocales()) {
            Toast.makeText(getApplicationContext(),"LOCALES"+ locale.getLanguage() + "_" + locale.getCountry() + " [" + locale.getDisplayName(),Toast.LENGTH_LONG).show();
        }*/
    //check for TTS data
    //   intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
    //         "stg say something");
    //txtSpeechInput.setText(result.get(0));

    //speak straight away
        /*long time1=System.currentTimeMillis();
        while(System.currentTimeMillis()<time1+10*1000)
        {

        }*/

    //act on result of TTS data check
  /*  protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == MY_DATA_CHECK_CODE) {
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
    }*/
}
