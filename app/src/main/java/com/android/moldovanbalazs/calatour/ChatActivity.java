package com.android.moldovanbalazs.calatour;

import android.icu.util.LocaleData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.moldovanbalazs.calatour.adapter.RecyclerViewAdatper;
import com.android.moldovanbalazs.calatour.model.ChatMessage;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button sendButton;
    EditText message;
    RecyclerViewAdatper recyclerViewAdatper;


    List<ChatMessage> messages = new ArrayList<>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
        recyclerViewAdatper = new RecyclerViewAdatper(messages, this.getBaseContext());
        recyclerView.setAdapter(recyclerViewAdatper);

        sendButton = findViewById(R.id.sendButton);
        message = findViewById(R.id.editChatMessage);



        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages.add(new ChatMessage("Sender", message.getText().toString(), DateFormat.getDateTimeInstance().format(new Date())));
                messages.add(new ChatMessage("Computer", "Automated message " + String.valueOf(++count), DateFormat.getDateTimeInstance().format(new Date())));
                recyclerViewAdatper.notifyDataSetChanged();

            }
        });
    }
}
