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

/**
 * Created by alex on 11/09/2017.
 */

/* public class Settings {
} */

public class Settings extends AppCompatActivity {
    final String PREFS_NAME = "AOP_PREFS";
    public static final String PREFS_KEY = "ADP_PREFS_String";
   // SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

    RelativeLayout rl;
    TextView checkBoxTest;
    CheckBox bgSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        checkBoxTest = (TextView) findViewById(R.id.checkBoxTester);
        // bgSwitch.setChecked(true);
        bgSwitch = (CheckBox) findViewById(R.id.bgSwitch);

        SharedPreferences prefs = getSharedPreferences("bgColour", MODE_PRIVATE);
        String colour = prefs.getString("bgColour", "WHITE");

        rl = (RelativeLayout)findViewById(R.id.testRL);
        if(colour.equals("WHITE")) {
            rl.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            rl.setBackgroundColor(Color.parseColor("#e5feff"));
        }



        bgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("bgColour", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                String colourSelected = "";

                if (bgSwitch.isChecked()) {
                    checkBoxTest.setText("test");
                    colourSelected = "LIGHTBLUE";
                    editor.putString("bgColour", colourSelected);
                    editor.apply();

                } else {
                    checkBoxTest.setText("test2");
                    colourSelected = "WHITE";
                    editor.putString("bgColour", colourSelected);
                    editor.commit();

                }
            }
        });

        //bgSwitch.setOnCheckedChangeListener() {
        //     checkBoxTest.setText("test");
        // };

    }



        /* if (bgSwitch.isChecked()) {
            checkBoxTest.setText("test1");
        } else {

            checkBoxTest.setText("test2");
        } */


    // This method is called when the home button is clicked, to take the user to the home page
    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

// https://developer.android.com/guide/topics/ui/controls/spinner.html
// https://developer.android.com/guide/topics/ui/controls/spinner.html