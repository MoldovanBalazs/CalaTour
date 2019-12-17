package com.android.moldovanbalazs.calatour;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.moldovanbalazs.calatour.model.LoginRequest;
import com.android.moldovanbalazs.calatour.model.LoginResponse;
import com.android.moldovanbalazs.calatour.network.LoginAPI;
import com.android.moldovanbalazs.calatour.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText username, password;
    TextView userError, passwordError, buttonError;
    LoginPresenter loginPresenter;
    Driver driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        driver = (Driver)getApplication();
        loginPresenter = new LoginPresenter(this, driver.getRetrofit().create(LoginAPI.class));

        login = findViewById(R.id.button);
        username = findViewById(R.id.userInput);
        password = findViewById(R.id.passwordInput);
        userError = findViewById(R.id.usernameError);
        passwordError = findViewById(R.id.passwordError);
        buttonError = findViewById(R.id.buttonError);
        username.setText("moldovanbalazs");
        password.setText("moldovanbalazs1234");
    }

    @SuppressLint("SetTextI18n")
    public void login(View view) {
        if(username.getText().length() < 4) {
            userError.setText("username too short");
        } else {
            userError.setText("");
        }

//        if(password.getText().length() < 4) {
//            passwordError.setText("password too short");
//        } else {
//            passwordError.setText("");
//        }
//
//        if(username.getText().toString().equals("admin") && password.getText().toString().equals("pass")) {
//            buttonError.setTextColor(Color.GREEN);
//            buttonError.setText("OK!");
//            Intent intent = new Intent(this, OffersActivity.class);
//            startActivity(intent);
//        } else {
//            buttonError.setTextColor(Color.RED);
//            buttonError.setText("Wrong Credentials");
//        }



        LoginRequest loginRequest = new LoginRequest(username.getText().toString(), password.getText().toString());
        loginPresenter.login(loginRequest);
    }

    public void loginSuccess(LoginResponse response){
        Log.d("RESPONSE", response.getId() + " " + response.getToken() + " " + response.getDisplay());
        Intent intent = new Intent(this, OffersActivity.class);
        startActivity(intent);
    }

    public void loginFailure() {
        passwordError.setText("bad password ");
    }

    public void logoutSuccess(LoginResponse responseBody) {
        Toast.makeText ( this, "Logged out!", Toast.LENGTH_LONG).show();
    }
}
