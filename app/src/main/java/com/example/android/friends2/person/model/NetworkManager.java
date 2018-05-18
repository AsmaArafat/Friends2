package com.example.android.friends2.person.model;

import android.util.JsonReader;

import com.example.android.friends2.Person;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by g on 24/03/2018.
 */

public class NetworkManager {
    static JsonReader jsonReader;

    public static JsonReader loadData (URL url) throws IOException {
        ///output result
        ///open hhtp connection request
        //URL url = new URL("http://demo7261611.mockable.io/people");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        if (httpURLConnection.getResponseCode() == 200) {
            //get response
            InputStream inputStream = httpURLConnection.getInputStream();
            ///read from stream with my stream and format
            InputStreamReader inputStreamReader =
                    new InputStreamReader(inputStream, "UTF-8");
            //convert to json object
             jsonReader = new JsonReader(inputStreamReader);
        }
        return (jsonReader);

    }

}
