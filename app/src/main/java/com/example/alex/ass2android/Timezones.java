package com.example.alex.ass2android;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Timezones extends AppCompatActivity {

    RelativeLayout llTimezones;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timezones);


        llTimezones = (RelativeLayout) findViewById(R.id.llTimezones);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

        /* if statement which dictates what colour the background will be, if colour = white,
        then background of llLogin is changed and if not white, then changed to a light blue colour
         */
        String colour = prefs.getString("bgColour", "WHITE");
        if(colour.equals("WHITE")) {
            llTimezones.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            llTimezones.setBackgroundColor(Color.parseColor("#e5feff"));
        }
        // ArrayAdapter<String> adapter;
        /* adapter = new ArrayAdapter<>(this, R.layout.activity_timezones, R.id.listContentFiller, values);
        setListAdapter(adapter); */



    }
    // This method is called when the home button is clicked, to take the user to the home page
    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }




}
