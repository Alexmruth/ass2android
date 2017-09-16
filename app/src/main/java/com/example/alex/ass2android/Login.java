package com.example.alex.ass2android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;


/**
 * Created by alex on 11/09/2017.
 */

/* public class Login {
} */


public class Login extends AppCompatActivity {
     final String PREFS_NAME = "AOP_PREFS";
     public static final String PREFS_KEY = "ADP_PREFS_String";
     SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

     CheckBox rememberMe;
     EditText usernameLogin;
     EditText passwordLogin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        //usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        //passwordLogin = (EditText) findViewById(R.id.passwordLogin);

        if(rememberMe.isChecked()){
            String username = usernameLogin.getText().toString();
            String password = passwordLogin.getText().toString();
            SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.putString("password", password);
            editor.commit();
        }
    }
}
