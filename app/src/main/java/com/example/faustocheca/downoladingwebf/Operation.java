package com.example.faustocheca.downoladingwebf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.SystemClock;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by faustocheca on 1/9/16.
 */
public class Operation extends AsyncTask<String, Void, Bitmap> {

    long timeDifference;
    Bitmap bitmap;
    long startTime = SystemClock.currentThreadTimeMillis();
    HttpURLConnection connection;




    public long getTimeDifference() {
        return timeDifference;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {


        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            InputStream input = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(input);
            timeDifference = (SystemClock.currentThreadTimeMillis()-startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;






    }
}