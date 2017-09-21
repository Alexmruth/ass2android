package com.example.alex.ass2android;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;


public class Login extends AppCompatActivity {

    CheckBox rememberMe;
    EditText usernameLogin;
    EditText passwordLogin;
    EditText usernameSignup;
    EditText passwordSignup;
    RelativeLayout llLogin;
    Button loginBtn;
    Button signupBtn;
    private String username;
    private String password;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        llLogin = (RelativeLayout) findViewById(R.id.llLogin);
        usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        usernameSignup = (EditText) findViewById(R.id.usernameSignup);
        passwordSignup = (EditText) findViewById(R.id.passwordSignup);
        rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        signupBtn = (Button) findViewById(R.id.signupBtn);

        //Calling shared preferences file
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

        /* if statement which dictates what colour the background will be, if colour = white,
        then background of llLogin is changed and if not white, then changed to a light blue colour
         */
        String colour = prefs.getString("bgColour", "WHITE");
        if(colour.equals("WHITE")) {
            llLogin.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            llLogin.setBackgroundColor(Color.parseColor("#e5feff"));
        }
        boolean checked = prefs.getBoolean("checked", true);
        if (checked) {
            rememberMe.setChecked(true);
        } else {
            rememberMe.setChecked(false);
        }

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameSignup.getText().toString().trim();
                password = passwordSignup.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()) {

                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                boolean checked;
                if(rememberMe.isChecked()){
                    checked = true;
                    String username = usernameLogin.getText().toString();
                    String password = passwordLogin.getText().toString();
                    editor.putBoolean("checked", checked);
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.commit();
                } else {
                    checked = false;
                    editor.putBoolean("checked", checked);
                    editor.remove("username");
                    editor.remove("password");
                    editor.commit();
                }
            }
        });

        String defaultString = "";
        String savedUsername = prefs.getString("username", defaultString);
        String savedPassword = prefs.getString("password", defaultString);
        //if (savedUsername.isEmpty() && savedPassword.isEmpty()){

       // } else {
            usernameLogin.setText(savedUsername);
            passwordLogin.setText(savedPassword);
       // }


        //usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        //passwordLogin = (EditText) findViewById(R.id.passwordLogin);


    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
