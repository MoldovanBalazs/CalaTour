package com.android.moldovanbalazs.calatour;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.moldovanbalazs.calatour.model.ChatMessage;

public class ChatViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView message;
    private TextView timeStamp;

    public ChatViewHolder(View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.chatSender);
        message = itemView.findViewById(R.id.chatMessage);
        timeStamp = itemView.findViewById(R.id.chatTimeStamp);
    }

    public void bindViewHolder(ChatMessage chatMessage) {
        title.setText(chatMessage.getTitle());
        message.setText(chatMessage.getMessage());
        timeStamp.setText(chatMessage.getTimeStamp());
    }
}
