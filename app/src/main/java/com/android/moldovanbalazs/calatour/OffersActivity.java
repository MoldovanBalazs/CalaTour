package com.android.moldovanbalazs.calatour;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.moldovanbalazs.calatour.adapter.OfferAdapter;
import com.android.moldovanbalazs.calatour.model.Offer;
import com.android.moldovanbalazs.calatour.service.OffersService;

public class OffersActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ListView listView;
    OfferAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_activity);

        progressBar = findViewById(R.id.progressBar_cyclic);

        CountDownTimer countDownTimer = new CountDownTimer(1000, 5000) {
            int progress = 0;
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(progress);
                progress += 20;
            }

            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
            }
        };
        countDownTimer.start();

        listView = findViewById(R.id.offers_list);
        listView.setVisibility(View.GONE);

        OfferAdapter offerAdapter = new OfferAdapter(this, OffersService.getOffers());
        listView.setAdapter(offerAdapter);
        offerAdapter.notifyDataSetChanged();

        registerForContextMenu(listView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return  true;
    }

    public void onBackPressed() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder ( this );
        myDialog
                .setTitle ( "Confirmation" )
                .setMessage ( "Please confirm logout intention!" )
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Intent intent = new Intent(OffersActivity.super.getBaseContext(), MainActivity.class);
                        //startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.sign_out) {
            AlertDialog.Builder myDialog = new AlertDialog.Builder ( this );
            myDialog
                    .setTitle ( "Confirmation" )
                    .setMessage ( "Please confirm logout intention!" )
                    .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Intent intent = new Intent(OffersActivity.super.getBaseContext(), MainActivity.class);
                            //startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
        }
        if(id == R.id.resetList) {
            OfferAdapter adapter = (OfferAdapter) listView.getAdapter();
            adapter.clear();
            adapter.addAll(OffersService.getOffers());
            Toast.makeText ( this, "List reset!", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.chat) {
            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        OfferAdapter adapter = (OfferAdapter) listView.getAdapter();
        if(id == R.id.removeOffer) {
            adapter.remove(adapter.getItem(info.position));
        }
        if(id == R.id.addOffer) {
            adapter.add(adapter.getItem(info.position));
        }


        return super.onContextItemSelected(item);

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        // check if the display of the contextual menu has been triggered by the list
        if ( v.getId() == R.id.offers_list )
        {
            // identify selected element from the list
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

            ListView listView = (ListView) v;
            OfferAdapter adapter = (OfferAdapter) listView.getAdapter();
            Offer offer = adapter.getItem(info.position);


            menu.setHeaderTitle(offer.getTitle());
            // load the visual structure of the contextual menu
            getMenuInflater().inflate(R.menu.offers_context_menu, menu);
        }

    }
}
