package com.android.moldovanbalazs.calatour.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.moldovanbalazs.calatour.R;
import com.android.moldovanbalazs.calatour.model.Offer;

import java.util.List;

public class OfferAdapter extends ArrayAdapter<Offer> {

    public OfferAdapter(@NonNull Context context, @NonNull List<Offer> objects) {
        super(context, 0, objects);
    }

    public View getView (int position, View convertView, ViewGroup parent )
    {
        // get a reference to the LayoutInflater service
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        // check if we can reuse a previously defined cell which now is not visible anymore
        View myRow = (convertView == null) ?
                inflater.inflate ( R.layout.offer_list_element, parent, false ) : convertView;
        // get the visual elements and update them with the information from the model
        // for example:

        ( (TextView) myRow.findViewById(R.id.title)).setText(getItem(position).getTitle());
        ( (ImageView) myRow.findViewById(R.id.offerImage)).setImageResource(getItem(position).getImage());
        ( (TextView) myRow.findViewById(R.id.price)).setText(getItem(position).getPriceValue() + " " + getItem(position).getPriceCurrency());
        ( (TextView) myRow.findViewById(R.id.description)).setText(getItem(position).getDescription());
        return myRow;
    }
}
