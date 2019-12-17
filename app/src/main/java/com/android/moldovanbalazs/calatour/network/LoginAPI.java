package com.android.moldovanbalazs.calatour.network;

import com.android.moldovanbalazs.calatour.model.LoginResponse;
import com.android.moldovanbalazs.calatour.model.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface LoginAPI {

    @POST("/moodle/chat-piu/authenticate.php")
    @Headers("Content-type: application/json")
    Call<LoginResponse> login(@Body LoginRequest request);

    @HTTP(method = "DELETE", path = "/moodle/chat-piu/logout.php", hasBody = true)
    @Headers({"Content-type: application/json"})
    Call<Void> logoutAllSessions(@Body LoginRequest request);

    @PUT("/moodle/chat-piu/sendmessage.php")
    @Headers("Content-type: application/json")
    Call<Void> logoutAllSessions(@Header("Authorization")String header, @Body LoginRequest request);

}
