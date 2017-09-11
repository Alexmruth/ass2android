package com.example.alex.ass2android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by alex on 11/09/2017.
 */

/* public class Login {
} */


public class Login extends AppCompatActivity {
    /* public static final String PREFS_NAME = "ADP_PREFS";
     public static final String PREFS_KEY = "ADP_PREFS_String";
     CheckBox rememberMe;
     EditText usernameLogin;
     EditText passwordLogin; */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);

        if(rememberMe.isChecked()){
            String username = usernameLogin.getText().toString();
            String password = passwordLogin.getText().toString();
            SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("loginDetails", username);
            editor.putString("passwordDetails", password);
            editor.commit();
        } */
    }
}
