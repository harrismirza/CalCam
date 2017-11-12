package com.example.matth.calcam;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DataAccess daccess;
    int userId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daccess = new DataAccess();


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                HashMap<String, String> user;
                user = daccess.getUser(userId);
                HashMap<String, String> consumption;
                consumption = daccess.getUserConsumption(userId);
                String targetString = "Hi " + user.get("name") + ",\n";
                targetString += "Calories: " + consumption.get("calories") + "/" + user.get("calories_g") + "\n";
                targetString += "Fat: " + consumption.get("fat") + "/" + user.get("fat_g") + "\n";
                targetString += "Saturates: " + consumption.get("saturates") + "/" + user.get("saturates_g") + "\n";
                targetString += "Carbs: " + consumption.get("carbohydrates") + "/" + user.get("carbohydrates_g") + "\n";
                targetString += "Sugar: " + consumption.get("sugars") + "/" + user.get("sugars_g") + "\n";
                targetString += "Protein: " + consumption.get("protein") + "/" + user.get("protein_g") + "\n";
                targetString += "Salt: " + consumption.get("salt") + "/" + user.get("salt_g") + "\n";

                final String string = targetString;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText(string);
                    }
                });

            }
        });

    }

    public void openCamera(View view) {
        Intent newActivity = new Intent(this, BarcodeCaptureActivity.class);
        newActivity.putExtra(BarcodeCaptureActivity.AutoFocus, true);
        newActivity.putExtra(BarcodeCaptureActivity.UseFlash, false);
        startActivityForResult(newActivity, 9001);
    }
}
