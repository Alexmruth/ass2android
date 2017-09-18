package com.example.alex.ass2android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    final String PREFS_NAME = "AOP_PREFS";
    public static final String PREFS_KEY = "ADP_PREFS_String";


    Spinner timeZoneSetting;
    RelativeLayout rl;
    CheckBox bgSwitch;
    TextClock homeClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Defining widgets etc
        bgSwitch = (CheckBox) findViewById(R.id.bgSwitch);
        rl = (RelativeLayout)findViewById(R.id.testRL);
        timeZoneSetting = (Spinner) findViewById(R.id.timeZoneSetting);
        homeClock = (TextClock) findViewById(R.id.homeClockTest);
        SharedPreferences settingsPrefs = getSharedPreferences("settings", MODE_PRIVATE);

        /* Retrieving sharedpreferences settings which have been stored dictating the colour of the background
        as well as saving the state of the checkbox, either checked or not.
         */
        String colour = settingsPrefs.getString("bgColour", "WHITE"); //string of background colour
        boolean bgChecked = settingsPrefs.getBoolean("checked", false); // boolean of if bgSwitch is checked, true or false

        if (bgChecked == true) {
            bgSwitch.setChecked(true);
        } else {
            bgSwitch.setChecked(false);
        }

        // If statement below sets background colour of the relative layout according to sharedpreferences settings
        if(colour.equals("WHITE")) {
            rl.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            rl.setBackgroundColor(Color.parseColor("#e5feff"));
        }

        bgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settingsPrefs = getSharedPreferences("settings", MODE_PRIVATE);
                SharedPreferences.Editor sEditor = settingsPrefs.edit();

                String colourSelected;
                boolean checked;

                /* if bgSwitch CheckBox is changed, then the colour selected is changed according to
                checkbox state, and the following string and boolean values are stored. */
                if (bgSwitch.isChecked()) {
                    colourSelected = "LIGHTBLUE";
                    sEditor.putString("bgColour", colourSelected);
                    checked = true;
                    sEditor.putBoolean("checked", checked);
                    sEditor.commit();
                    rl.setBackgroundColor(Color.parseColor("#e5feff"));
                } else {
                    colourSelected = "WHITE";
                    sEditor.putString("bgColour", colourSelected);
                    checked = false;
                    sEditor.putBoolean("checked", checked);
                    sEditor.commit();
                    rl.setBackgroundColor(Color.parseColor("#ffffff"));
                }
            }
        });

        // Create an ArrayAdapter to apply my array of cities to the timezone settings spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.homeTzSetting, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        timeZoneSetting.setAdapter(adapter);

        timeZoneSetting.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }


    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            SharedPreferences settingsPrefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor sEditor = settingsPrefs.edit();
            String city = adapterView.getItemAtPosition(i).toString();
            String timeZoneSet;

            switch (city) {
                case "Brisbane":
                    timeZoneSet = "GMT+10";
                    sEditor.putString("timeZone", timeZoneSet);
                    sEditor.putString("timeZoneCity", city);
                    break;
                case "Sydney":
                    timeZoneSet = "GMT+10";
                    sEditor.putString("timeZone", timeZoneSet);
                    sEditor.putString("timeZoneCity", city);

                    break;
                case "Melbourne":
                    timeZoneSet = "GMT+10";
                    sEditor.putString("timeZone", timeZoneSet);
                    sEditor.putString("timeZoneCity", city);

                    break;
                case "Hobart":
                    timeZoneSet = "GMT+10";
                    sEditor.putString("timeZone", timeZoneSet);
                    sEditor.putString("timeZoneCity", city);
                    break;
                case "Canberra":
                    timeZoneSet = "GMT+10";
                    sEditor.putString("timeZone", timeZoneSet);
                    sEditor.putString("timeZoneCity", city);
                    break;
                case "Adelaide":
                    timeZoneSet = "Australia/Adelaide";
                    sEditor.putString("timeZone", timeZoneSet);
                    sEditor.putString("timeZoneCity", city);

                    break;
                case "Darwin":
                    timeZoneSet = "Australia/Adelaide";
                    sEditor.putString("timeZone", timeZoneSet);
                    sEditor.putString("timeZoneCity", city);

                    break;
                case "Perth":
                    timeZoneSet = "GMT+8";
                    sEditor.putString("timeZone", timeZoneSet);
                    sEditor.putString("timeZoneCity", city);

                    break;
            }
            sEditor.commit();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }


    // This method is called when the home button is clicked, to take the user to the home page
    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}