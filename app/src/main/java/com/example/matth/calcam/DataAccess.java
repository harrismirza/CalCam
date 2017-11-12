package com.example.matth.calcam;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import static android.content.ContentValues.TAG;
import static android.os.AsyncTask.execute;

/**
 * Created by matth on 11/11/2017.
 */

public class DataAccess {

    private String baseURL = "https://calcam-lz.herokuapp.com";

    public HashMap<String, String> getUser(final int userId){
        HashMap<String, String> map = new HashMap<>();
        try {
            URL requestURL = new URL(baseURL + "/user");
            HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
            myConnection.setRequestProperty("Content-Type", "application/json");
            myConnection.setRequestMethod("POST");

            //Create JSON
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", userId);

            OutputStream outputStream = myConnection.getOutputStream();
            outputStream.write(jsonObject.toString().getBytes());
            outputStream.close();

            if (myConnection.getResponseCode() == 200) {
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                JsonReader jsonReader = new JsonReader(responseBodyReader);

                jsonReader.beginObject(); // Start processing the JSON object
                while (jsonReader.hasNext()) { // Loop through all keys
                    map.put(jsonReader.nextName(), jsonReader.nextString()); // Fetch the next key

                }
            } else {
                // Error handling code goes here
            }

        } catch (IOException | JSONException e)
        {}

        return map;
    }

    public HashMap<String, String> getItem(final long barcode){

        HashMap<String, String> map = new HashMap<>();

        try {
            URL requestURL = new URL(baseURL + "/item");
            HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
            myConnection.setRequestMethod("POST");
            myConnection.setRequestProperty("Content-Type", "application/json");
            myConnection.connect();

            //Create JSON
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("barcode", barcode);

            OutputStream os = myConnection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(jsonObject.toString());
            osw.flush();
            osw.close();

            if (myConnection.getResponseCode() == 200) {
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                JsonReader jsonReader = new JsonReader(responseBodyReader);

                jsonReader.beginObject(); // Start processing the JSON object
                while (jsonReader.hasNext()) { // Loop through all keys
                    map.put(jsonReader.nextName(), jsonReader.nextString()); // Fetch the next key

                }

            } else {
                // Error handling code goes here
            }

        } catch (IOException | JSONException e)
        {}

        return map;
    }

    public HashMap<String, String> consume(final int userId, final long barcode){

        HashMap<String, String> map = new HashMap<>();

        try {
            URL requestURL = new URL(baseURL + "/user/consumeItem");
            HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
            myConnection.setRequestProperty("Content-Type", "application/json");
            myConnection.setRequestMethod("POST");

            //Create JSON
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", userId);
            jsonObject.put("barcode", barcode);

            OutputStream outputStream = myConnection.getOutputStream();
            outputStream.write(jsonObject.toString().getBytes());
            outputStream.close();

            if (myConnection.getResponseCode() == 200) {
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                JsonReader jsonReader = new JsonReader(responseBodyReader);

                jsonReader.beginObject(); // Start processing the JSON object
                while (jsonReader.hasNext()) { // Loop through all keys
                    map.put(jsonReader.nextName(), jsonReader.nextString()); // Fetch the next key
                }
            } else {
                // Error handling code goes here
                Log.e(TAG, myConnection.getResponseCode() + "");
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                os.write(jsonObject.toString().getBytes("UTF-8"));
                Log.e(TAG, os.toString());
            }

        } catch (IOException | JSONException e)
        {}


        return map;
    }

    public HashMap<String, String> getUserConsumption(final int userId){
        HashMap<String, String> map = new HashMap<>();

        try {
            URL requestURL = new URL(baseURL + "/user/consumption");
            HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
            myConnection.setRequestProperty("Content-Type", "application/json");
            myConnection.setRequestMethod("POST");

            //Create JSON
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", userId);

            OutputStream outputStream = myConnection.getOutputStream();
            outputStream.write(jsonObject.toString().getBytes());
            outputStream.close();

            if (myConnection.getResponseCode() == 200) {
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                JsonReader jsonReader = new JsonReader(responseBodyReader);

                jsonReader.beginObject(); // Start processing the JSON object
                while (jsonReader.hasNext()) { // Loop through all keys
                    if(jsonReader.nextName().equals("barcode")) {
                        map.put(jsonReader.nextName(), jsonReader.nextLong() + "");
                    }else {
                        map.put(jsonReader.nextName(), jsonReader.nextString());
                    }// Fetch the next key


                }
            } else {
                // Error handling code goes here
            }

        } catch (IOException | JSONException e)
        {}

        return map;
    }


    HashMap<String, String> createUser(final int userId, final String email, final String name, final int targetCalories, final int targetEnergy, final int targetFat, final int targetSaturates, final int targetCarbs, final int targetSugars, final int targetProtein, final int targetSalt){
        HashMap<String, String> map = new HashMap<>();

        class createUserClass implements Runnable
        {
            HashMap<String, String> map = new HashMap<>();

            private createUserClass(HashMap<String, String> map) {
                this.map = map;
            }

            @Override
            public void run() {
                try {
                    URL requestURL = new URL(baseURL + "/user/consumption");
                    HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
                    myConnection.setRequestMethod("POST");

                    //Create JSON
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", userId );
                    jsonObject.put("email", email);
                    jsonObject.put("name", name);
                    jsonObject.put("calories_g", targetCalories);
                    jsonObject.put("energy_g", targetEnergy);
                    jsonObject.put("fat_g", targetFat );
                    jsonObject.put("saturates_g", targetSaturates );
                    jsonObject.put("carbs_g", targetCarbs );
                    jsonObject.put("sugar_g", targetSugars );
                    jsonObject.put("protein_g", targetProtein );
                    jsonObject.put("salt_g", targetSalt );

                    OutputStream outputStream = myConnection.getOutputStream();
                    outputStream.write(jsonObject.toString().getBytes());
                    outputStream.close();

                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            map.put(jsonReader.nextName(), jsonReader.nextString()); // Fetch the next key

                            
                        }
                    } else {
                        // Error handling code goes here
                    }

                } catch (IOException | JSONException e)
                {}
            }
        }

        AsyncTask.execute(new createUserClass(map));

        return map;
    }

    HashMap<String, String> createItem(final long barcode, final int calories, final int energy, final int fat, final int saturates, final int carbs, final int sugars, final int protein, final int salt){
        HashMap<String, String> map = new HashMap<>();

        class createUserClass implements Runnable
        {
            HashMap<String, String> map = new HashMap<>();

            private createUserClass(HashMap<String, String> map) {
                this.map = map;
            }

            @Override
            public void run() {
                try {
                    URL requestURL = new URL(baseURL + "/user/consumption");
                    HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
                    myConnection.setRequestMethod("POST");

                    //Create JSON
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("barcode", barcode );
                    jsonObject.put("calories_g", calories );
                    jsonObject.put("energy_g", energy );
                    jsonObject.put("fat_g", fat );
                    jsonObject.put("saturates_g", saturates );
                    jsonObject.put("carbs_g", carbs );
                    jsonObject.put("sugar_g", sugars );
                    jsonObject.put("protein_g", protein );
                    jsonObject.put("salt_g", salt );

                    OutputStream outputStream = myConnection.getOutputStream();
                    outputStream.write(jsonObject.toString().getBytes());
                    outputStream.close();

                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            map.put(jsonReader.nextName(), jsonReader.nextString()); // Fetch the next key

                            
                        }
                    } else {
                        // Error handling code goes here
                    }

                } catch (IOException | JSONException e)
                {}
            }
        }

        AsyncTask.execute(new createUserClass(map));

        return map;
    }


}
