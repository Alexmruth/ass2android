package com.example.alex.ass2android;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.LinearLayout;


public class Login extends AppCompatActivity {

    CheckBox rememberMe;
    EditText usernameLogin;
    EditText passwordLogin;
    LinearLayout llLogin;
    Button loginBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        llLogin = (LinearLayout) findViewById(R.id.llLogin);
        usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        String colour = prefs.getString("bgColour", "WHITE");


        if(colour.equals("WHITE")) {
            llLogin.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            llLogin.setBackgroundColor(Color.parseColor("#e5feff"));
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rememberMe.isChecked()){
                    SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    String username = usernameLogin.getText().toString();
                    String password = passwordLogin.getText().toString();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.commit();
                }
            }
        });


        String defaultString = "";
        String savedUsername = prefs.getString("username", defaultString);
        String savedPassword = prefs.getString("password", defaultString);
        if (savedUsername.isEmpty() && savedPassword.isEmpty()){

        } else {
            usernameLogin.setText(savedUsername);
            passwordLogin.setText(savedPassword);
        }


        //usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        //passwordLogin = (EditText) findViewById(R.id.passwordLogin);


    }
}
