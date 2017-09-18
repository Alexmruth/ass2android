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
    final String PREFS_NAME = "AOP_PREFS";
    public static final String PREFS_KEY = "ADP_PREFS_String";
    RelativeLayout rl;
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

        rl = (RelativeLayout)findViewById(R.id.mainRL);
        if(colour.equals("WHITE")) {
            rl.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            rl.setBackgroundColor(Color.parseColor("#e5feff"));
        }

        homeClock.setTimeZone(timeZone);

    }
    public void goToSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }


}
