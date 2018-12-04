package com.tanat.testgrechko.loader;

import android.content.Context;
import android.os.Bundle;

import com.google.gson.Gson;
import com.tanat.testgrechko.Constants;
import com.tanat.testgrechko.model.Example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataLoader extends AbstractLoader<Example> {

    public DataLoader(Context context, Bundle args) {
        super(context);
        forceLoad();
    }

    @Override
    public Example loadInBackground() {
        InputStream inputStream;
        HttpURLConnection urlConnection;
        BufferedReader reader;
        Gson gson = new Gson();

        try {
            URL url = new URL(Constants.getPlaces());

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            inputStream = url.openConnection().getInputStream();
            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            Example example = gson.fromJson(buffer.toString(), Example.class);
            return example;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
