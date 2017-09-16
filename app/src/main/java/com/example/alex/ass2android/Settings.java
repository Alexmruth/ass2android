package com.example.alex.ass2android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    final String PREFS_NAME = "AOP_PREFS";
    public static final String PREFS_KEY = "ADP_PREFS_String";


    RelativeLayout rl;
    CheckBox bgSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Defining widgets
        bgSwitch = (CheckBox) findViewById(R.id.bgSwitch);
        rl = (RelativeLayout)findViewById(R.id.testRL);

        // Retrieving sharedpreferences settings which have been stored dictating the colour of the background
        SharedPreferences prefs = getSharedPreferences("bgColour", MODE_PRIVATE);
        String colour = prefs.getString("bgColour", "WHITE");
        
        SharedPreferences bgColourCB = getSharedPreferences("bgColourCB", MODE_PRIVATE);
        String isChecked = bgColourCB.getString("bgColourChecked", "false");

        if(isChecked.equals("true")) {
            bgSwitch.setChecked(true);
        } else {
            bgSwitch.setChecked(false);
        }


        if(colour.equals("WHITE")) {
            rl.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            rl.setBackgroundColor(Color.parseColor("#e5feff"));
        }



        bgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences bgColourPrefs = getSharedPreferences("bgColour", MODE_PRIVATE);
                SharedPreferences.Editor bgEditor = bgColourPrefs.edit();

                SharedPreferences bgColourCBPrefs = getSharedPreferences("bgColourCB", MODE_PRIVATE);
                SharedPreferences.Editor bgColourEditorCB = bgColourCBPrefs.edit();
                String colourSelected;
                boolean checked;

                if (bgSwitch.isChecked()) {
                    colourSelected = "LIGHTBLUE";
                    bgEditor.putString("bgColour", colourSelected);
                    bgEditor.commit();
                    checked = true;
                    bgColourEditorCB.putBoolean("checked", checked);
                    bgColourEditorCB.commit();
                    rl.setBackgroundColor(Color.parseColor("#e5feff"));

                } else {
                    colourSelected = "WHITE";
                    bgEditor.putString("bgColour", colourSelected);
                    bgEditor.commit();
                    checked = false;
                    bgColourEditorCB.putBoolean("checked", checked);
                    bgColourEditorCB.commit();
                    rl.setBackgroundColor(Color.parseColor("#ffffff"));
                }
            }
        });

    }


    // This method is called when the home button is clicked, to take the user to the home page
    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}