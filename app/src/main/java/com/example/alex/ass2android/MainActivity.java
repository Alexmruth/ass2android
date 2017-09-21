package com.example.alex.ass2android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rlHome;
    Button settingsBtn;
    TextClock homeClock;
    TextView timeLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingsBtn = (Button) findViewById(R.id.settingsBtn);
        homeClock = (TextClock) findViewById(R.id.homeClock);
        timeLocation = (TextView) findViewById(R.id.timeLocation);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        String colour = prefs.getString("bgColour", "WHITE");
        String timeZone = prefs.getString("timeZone", "Default");
        String timeZoneCity = prefs.getString("timeZoneCity", "Default");

        /* if statement which dictates what colour the background will be, if colour = white,
        then background of llLogin is changed and if not white, then changed to a light blue colour
         */
        rlHome = (RelativeLayout)findViewById(R.id.rlHome);
        if(colour.equals("WHITE")) {
            rlHome.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            rlHome.setBackgroundColor(Color.parseColor("#e5feff"));
        }
        // Sets the timezone according to the shared prefs value which was chosen in the settings page
        homeClock.setTimeZone(timeZone);
        // Sets the timezone city according to the shared prefs value which was chosen in the settings page
        timeLocation.setText(timeZoneCity);

    }
    public void goToSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }


    public void goToTimezones(View view) {
        Intent intent = new Intent(this, Timezones.class);
        startActivity(intent);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
