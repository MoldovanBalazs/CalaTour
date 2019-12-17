package com.android.moldovanbalazs.calatour.presenter;

import android.util.Log;
import android.view.View;

import com.android.moldovanbalazs.calatour.MainActivity;
import com.android.moldovanbalazs.calatour.model.LoginRequest;
import com.android.moldovanbalazs.calatour.model.LoginResponse;
import com.android.moldovanbalazs.calatour.network.LoginAPI;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {

        private MainActivity view;
        private LoginAPI loginAPI;

        public LoginPresenter(MainActivity view, LoginAPI loginAPI) {
            this.view = view;
            this.loginAPI = loginAPI;
        }

        public void login(final LoginRequest loginRequest) {
            loginAPI.login(loginRequest).enqueue(
                    new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.isSuccessful()) {
                                // request is successful and response is mapped in responseBody
                                LoginResponse responseBody = (LoginResponse) response.body();
                                if (responseBody != null) {
                                    view.loginSuccess(responseBody);
                                    Log.d("ServerResponse", "SUCCESS");
                                }

                            } else {
                                //view.loginFailure();
                                // request is not successful (some error occurred on the server)
                                int errorStatusCode = response.code();
                                String errorMessage;
                                // verify if the server has sent more details about the error
                                try {
                                    errorMessage = response.errorBody().string();
                                } catch (IOException e) {
                                    errorMessage = "Error message cannot be obtained!";
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            view.loginFailure();
                            Log.d("ServerResponse", "FAILURE");
                        }
                    }
            );
        }

            public void logout(final LoginRequest loginRequest) {
                loginAPI.logoutAllSessions(loginRequest).enqueue(
                        new Callback<Void>() {
                            @Override
                            public void onResponse(Call call, Response response) {
                                if (response.isSuccessful()) {
                                    // request is successful and response is mapped in responseBody
                                    LoginResponse responseBody = (LoginResponse) response.body();
                                    if (responseBody != null) {
                                        view.logoutSuccess(responseBody);
                                        Log.d("ServerResponse", "SUCCESS");
                                    }

                                } else {
                                    //view.loginFailure();
                                    // request is not successful (some error occurred on the server)
                                    int errorStatusCode = response.code();
                                    String errorMessage;
                                    // verify if the server has sent more details about the error
                                    try {
                                        errorMessage = response.errorBody().string();
                                    } catch (IOException e) {
                                        errorMessage = "Error message cannot be obtained!";
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call call, Throwable t) {
                                view.loginFailure();
                                Log.d("ServerResponse", "FAILURE");
                            }
                        }
                );
        }


}
