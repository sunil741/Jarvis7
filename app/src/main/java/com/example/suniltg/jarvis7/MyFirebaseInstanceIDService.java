package com.example.suniltg.jarvis7;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by sunil TG on 12/27/2016.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken().toString();
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("mypre", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("token", token);
        editor.commit();
        // Toast.makeText(this,"token reccieved "+token,Toast.LENGTH_LONG).show();
        //sendRegistrationToServer(token);
       /* String login_url = "http://35.166.216.15/register.php";
        // if(type.equals("login")) {
        try {

            //       String user_name = params[1];
            //     String password = params[2];
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("Token","UTF-8")+"="+URLEncoder.encode(token,"UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="hi";
            String line="";
            while((line = bufferedReader.readLine())!= null) {
                result += line;
            }
            System.out.println("Result is"+result);
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("affsfffdfafafafafa"+token);
    }

    // private void sendRegistrationToServer(String refreshedToken) {
        /*OkHttpClient httpClient = new OkHttpClient();
        RequestBody requestBody= new FormBody.Builder().add("Token",refreshedToken).build();
        Request request= new Request.Builder().url("http://10.0.2.2/fcm/register.php").post(requestBody).build();
        try {
            httpClient.newCall(request).execute();
        } catch (IOException e) {


            e.printStackTrace();
        }*/

       /* String login_url = "http://10.0.2.2/fcm/register.php";
        try
        {
            URL url;
            url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
            } catch (ProtocolException e) {
                Log.i("posy","gtg"+e);
                e.printStackTrace();
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("Token","UTF-8")+"="+URLEncoder.encode(refreshedToken,"UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line="";
            while((line = bufferedReader.readLine())!= null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            Log.i("posy","gtg1"+e);
            e.printStackTrace();
        } catch (IOException e) {
            Log.i("posy","gtg2"+e);
            e.printStackTrace();
        }
        return;
    }*/
    }
}





