package com.example.suniltg.jarvis7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

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
public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;

    BackgroundWorker (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String login_url = "http://35.166.216.15/namewise.php";
        try {
            SharedPreferences sharedPref = context.getSharedPreferences("mypre",Context.MODE_PRIVATE);
            String name2 = sharedPref.getString("name","sdsfsadfadsfafa");
            //String token=params[0];
            String name=params[0];
            String message=params[1];
            System.out.println("printing name "+name);
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            System.out.println("printing stafe "+1);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            System.out.println("printing stage "+2);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
           String post_data=  URLEncoder.encode("from","UTF-8")+"="+URLEncoder.encode(name2,"UTF-8")+"&"
                   +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                    +URLEncoder.encode("message","UTF-8")+"="+URLEncoder.encode(message,"UTF-8");
            System.out.println("printing stage "+3);
            bufferedWriter.write(post_data);
            System.out.println("printing stage "+4);
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
            System.out.println("printing result"+result);
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPreExecute() {
      //  alertDialog = new AlertDialog.Builder(context).create();
        //alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
  //      alertDialog.setMessage(result);
//        alertDialog.show();
        // delegate.processFinish(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}



