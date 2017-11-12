package com.example.matth.calcam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private DataAccess daccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCamera(View view) {
        Intent newActivity = new Intent(this, BarcodeCaptureActivity.class);
        newActivity.putExtra(BarcodeCaptureActivity.AutoFocus, true);
        newActivity.putExtra(BarcodeCaptureActivity.UseFlash, false);
        startActivityForResult(newActivity, 9001);
    }
}
