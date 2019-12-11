package com.android.moldovanbalazs.calatour;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText username, password;
    TextView userError, passwordError, buttonError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.button);
        username = findViewById(R.id.userInput);
        password = findViewById(R.id.passwordInput);
        userError = findViewById(R.id.usernameError);
        passwordError = findViewById(R.id.passwordError);
        buttonError = findViewById(R.id.buttonError);
        username.setText("admin");
        password.setText("pass");
    }

    @SuppressLint("SetTextI18n")
    public void login(View view) {
        if(username.getText().length() < 4) {
            userError.setText("username too short");
        } else {
            userError.setText("");
        }

        if(password.getText().length() < 4) {
            passwordError.setText("password too short");
        } else {
            passwordError.setText("");
        }

        if(username.getText().toString().equals("admin") && password.getText().toString().equals("pass")) {
            buttonError.setTextColor(Color.GREEN);
            buttonError.setText("OK!");
            Intent intent = new Intent(this, OffersActivity.class);
            startActivity(intent);
        } else {
            buttonError.setTextColor(Color.RED);
            buttonError.setText("Wrong Credentials");
        }
    }
}
