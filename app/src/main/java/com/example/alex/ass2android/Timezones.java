package com.example.alex.ass2android;

/**
 * Created by alex on 11/09/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Timezones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timezones);
    }
    // This method is called when the home button is clicked, to take the user to the home page
    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}