package com.android.moldovanbalazs.calatour.presenter;

import com.android.moldovanbalazs.calatour.ChatActivity;
import com.android.moldovanbalazs.calatour.OffersActivity;
import com.android.moldovanbalazs.calatour.network.LoginAPI;

public class ChatPresenter {
    private ChatActivity view;
    private LoginAPI loginAPI;

    public ChatPresenter(ChatActivity view, LoginAPI loginAPI) {
        this.view = view;
        this.loginAPI = loginAPI;
    }




}
