package com.android.moldovanbalazs.calatour.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.moldovanbalazs.calatour.ChatViewHolder;
import com.android.moldovanbalazs.calatour.R;
import com.android.moldovanbalazs.calatour.model.ChatMessage;

import java.util.List;

public class RecyclerViewAdatper extends RecyclerView.Adapter<ChatViewHolder> {

    private List<ChatMessage> objects;
    private Context context;

    public RecyclerViewAdatper(List objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
// interpret the XML file and create Java internal structure
        View layout = layoutInflater.inflate(R.layout.chat_element, viewGroup, false);
// returns the view holder which is created from the view
        return new ChatViewHolder(layout);


    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder chatViewHolder, int i) {
        chatViewHolder.bindViewHolder ( objects.get ( i ) );
    }



    @Override
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public int getItemViewType ( int position )
    {
       return 0;
    }
}
