package com.example.alex.ass2android;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Timezones extends ListActivity {

    RelativeLayout rlTimezones;
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_timezones);

        String[] values;
        values = getResources().getStringArray(R.array.homeTzSetting);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.rowlayout,
                R.id.listContentFiller, values));

        rlTimezones = (RelativeLayout) findViewById(R.id.rlTimezones);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        String colour = prefs.getString("bgColour", "WHITE");

        if(colour.equals("WHITE")) {
            rlTimezones.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            rlTimezones.setBackgroundColor(Color.parseColor("#e5feff"));
        }
        // ArrayAdapter<String> adapter;
        /* adapter = new ArrayAdapter<>(this, R.layout.activity_timezones, R.id.listContentFiller, values);
        setListAdapter(adapter); */



    }

    // This method is called when the home button is clicked, to take the user to the home page
    /*public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    } */
}
