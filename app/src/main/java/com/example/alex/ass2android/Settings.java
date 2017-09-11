package com.example.alex.ass2android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

/**
 * Created by alex on 11/09/2017.
 */

/* public class Settings {
} */

public class Settings extends AppCompatActivity {

    Switch bgSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

     //   bgSwitch = (Switch) findViewById(R.id.bgSwitch);
        bgSwitch.setChecked(false);
        bgSwitch.setOnClickListener((View.OnClickListener) this);

    }
    // This method is called when the home button is clicked, to take the user to the home page
    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick(View v) {
       /* if (v.getId() == R.id.bgSwitch) {
            if (bgSwitch.isChecked()) {
                bgSwitch.setTextOn("Hello");
            }
        } */
    }
}

// https://developer.android.com/guide/topics/ui/controls/spinner.html
// https://developer.android.com/guide/topics/ui/controls/spinner.html