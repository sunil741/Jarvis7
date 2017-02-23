package com.example.suniltg.jarvis7;

import android.app.AlertDialog;
import android.content.Context;
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
 * Created by sunil TG on 12/28/2016.
 */
public class BackgroundWorker2 extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;

    BackgroundWorker2 (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String login_url = "http://35.166.216.15/register.php";
        String token=context.getSharedPreferences("mypre",Context.MODE_PRIVATE).getString("token","jkrkr");
        String name=context.getSharedPreferences("mypre",Context.MODE_PRIVATE).getString("name","sdfkls");
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
            String post_data = URLEncoder.encode("token","UTF-8")+"="+URLEncoder.encode(token,"UTF-8")+"&"
                    +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");

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



