package com.android.moldovanbalazs.calatour.model;


public class ChatMessage {

    private String title;
    private String message;
    private String timeStamp;

    public ChatMessage(String title, String message, String timeStamp) {
        this.title = title;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
