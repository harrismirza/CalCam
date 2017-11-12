package com.example.matth.calcam;

import android.os.AsyncTask;
import android.util.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by matth on 11/11/2017.
 */

public class DataAccess {

    public String baseURL = "";
    /*
       GET /users/:userId - Get User
       POST /users/:userId - Create User
       GET /users/:userId/food/:foodId - Consume
     */
    void getUser(final int userId){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL requestURL = new URL(baseURL + "/user");
                    HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
                    myConnection.setRequestMethod("POST");

                    //Create JSON
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", userId + "");

                    OutputStream outputStream = myConnection.getOutputStream();
                    outputStream.write(jsonObject.toString().getBytes());
                    outputStream.close();

                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            String key = jsonReader.nextName(); // Fetch the next key
                            String value = jsonReader.nextString();

                            break; // Break out of the loop
                        }
                    } else {
                        // Error handling code goes here
                    }

                }catch (MalformedURLException e)
                {}
                catch (IOException e)
                {}
                catch (JSONException e)
                {}
            }
        });
    }

    void getItem(final int barcode){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL requestURL = new URL(baseURL + "/item");
                    HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
                    myConnection.setRequestMethod("POST");

                    //Create JSON
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("barcode", barcode + "");

                    OutputStream outputStream = myConnection.getOutputStream();
                    outputStream.write(jsonObject.toString().getBytes());
                    outputStream.close();

                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            String key = jsonReader.nextName(); // Fetch the next key
                            String value = jsonReader.nextString();

                            break; // Break out of the loop
                        }
                    } else {
                        // Error handling code goes here
                    }

                }catch (MalformedURLException e)
                {}
                catch (IOException e)
                {}
                catch (JSONException e)
                {}
            }
        });
    }

    void consume(final int userId, final int barcode){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL requestURL = new URL(baseURL + "/user/consumeItem");
                    HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
                    myConnection.setRequestMethod("POST");

                    //Create JSON
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", userId + "");
                    jsonObject.put("barcode", barcode + "");

                    OutputStream outputStream = myConnection.getOutputStream();
                    outputStream.write(jsonObject.toString().getBytes());
                    outputStream.close();

                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            String key = jsonReader.nextName(); // Fetch the next key
                            String value = jsonReader.nextString();

                            break; // Break out of the loop
                        }
                    } else {
                        // Error handling code goes here
                    }

                }catch (MalformedURLException e)
                {}
                catch (IOException e)
                {}
                catch (JSONException e)
                {}
            }
        });
    }

    void getUserConsumption(final int userId){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL requestURL = new URL(baseURL + "/user/consumption");
                    HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
                    myConnection.setRequestMethod("POST");

                    //Create JSON
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", userId + "");

                    OutputStream outputStream = myConnection.getOutputStream();
                    outputStream.write(jsonObject.toString().getBytes());
                    outputStream.close();

                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            String key = jsonReader.nextName(); // Fetch the next key
                            String value = jsonReader.nextString();

                            break; // Break out of the loop
                        }
                    } else {
                        // Error handling code goes here
                    }

                }catch (MalformedURLException e)
                {}
                catch (IOException e)
                {}
                catch (JSONException e)
                {}
            }
        });
    }


    void createUser(final int userId, final String email, final String name, final int targetCalories, final int targetEnergy, final int targetFat, final int targetSaturates, final int targetCarbs, final int targetSugars, final int targetProtein, final int targetSalt){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL requestURL = new URL(baseURL + "/user/consumption");
                    HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
                    myConnection.setRequestMethod("POST");

                    //Create JSON
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", userId + "");
                    jsonObject.put("email", email + "");
                    jsonObject.put("name", name + "");
                    jsonObject.put("calories_g", targetCalories + "");
                    jsonObject.put("energy_g", targetEnergy + "");
                    jsonObject.put("fat_g", targetFat + "");
                    jsonObject.put("saturates_g", targetSaturates + "");
                    jsonObject.put("carbs_g", targetCarbs + "");
                    jsonObject.put("sugar_g", targetSugars + "");
                    jsonObject.put("protein_g", targetProtein + "");
                    jsonObject.put("salt_g", targetSalt + "");


                    OutputStream outputStream = myConnection.getOutputStream();
                    outputStream.write(jsonObject.toString().getBytes());
                    outputStream.close();

                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            String key = jsonReader.nextName(); // Fetch the next key
                            String value = jsonReader.nextString();

                            break; // Break out of the loop
                        }
                    } else {
                        // Error handling code goes here
                    }

                }catch (MalformedURLException e)
                {}
                catch (IOException e)
                {}
                catch (JSONException e)
                {}
            }
        });
    }

    void createItem(final int barcode, final int calories, final int energy, final int fat, final int saturates, final int carbs, final int sugars, final int protein, final int salt){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL requestURL = new URL(baseURL + "/user/consumption");
                    HttpsURLConnection myConnection = (HttpsURLConnection) requestURL.openConnection();
                    myConnection.setRequestMethod("POST");

                    //Create JSON
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("barcode", barcode + "");
                    jsonObject.put("calories_g", calories + "");
                    jsonObject.put("energy_g", energy + "");
                    jsonObject.put("fat_g", fat + "");
                    jsonObject.put("saturates_g", saturates + "");
                    jsonObject.put("carbs_g", carbs + "");
                    jsonObject.put("sugar_g", sugars + "");
                    jsonObject.put("protein_g", protein + "");
                    jsonObject.put("salt_g", salt + "");


                    OutputStream outputStream = myConnection.getOutputStream();
                    outputStream.write(jsonObject.toString().getBytes());
                    outputStream.close();

                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            String key = jsonReader.nextName(); // Fetch the next key
                            String value = jsonReader.nextString();

                            break; // Break out of the loop
                        }
                    } else {
                        // Error handling code goes here
                    }

                }catch (MalformedURLException e)
                {}
                catch (IOException e)
                {}
                catch (JSONException e)
                {}
            }
        });
    }


}
