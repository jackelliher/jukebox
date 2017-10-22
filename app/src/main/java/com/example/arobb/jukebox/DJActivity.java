package com.example.arobb.jukebox;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DJActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj);

        new RetrieveData().execute("http://162.254.253.19:3000/send_song?song_id=poopypoopoop");


    }

    private class RetrieveData extends AsyncTask<String, Void, String> {
        String url = "";
        HttpURLConnection connection;
        BufferedReader br;
        @Override
        protected String doInBackground(String... params) {
            url = params[0];
            try {
                return response();
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }

        String response() throws MalformedURLException, IOException, ProtocolException{
            URL newUrl = new URL(url);

            connection = (HttpURLConnection) newUrl.openConnection();
            String dummy = connection.getClass().toString();//necessary for SamSung phones
            Logger.getLogger(dummy).setLevel(Level.OFF);//necessary for SamSung phones

            connection.setRequestMethod("GET");

            connection.connect();

            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String response;
            while ((response = br.readLine()) != null) {
                System.out.println("=========================================\n"+response);
                builder.append(response);
            }

            return builder.toString();
        }

        @Override
        protected void onPostExecute(String str) {
            super.onPostExecute(str);
            System.err.println(str);
            TextView screenText = (TextView) findViewById(R.id.test);
            screenText.setText(str);
        }
    }
}
