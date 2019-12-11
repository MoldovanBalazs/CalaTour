package com.android.moldovanbalazs.calatour.service;

import com.android.moldovanbalazs.calatour.R;
import com.android.moldovanbalazs.calatour.model.Offer;

import java.util.ArrayList;
import java.util.List;

public class OffersService {

    public static List<Offer> getOffers() {
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer("Offer 1", R.drawable.offer_1, 100, "EURO", "This is a description for offer 1"));
        offers.add(new Offer("Offer 2", R.drawable.offer_2, 600, "LEI", "This is a description for offer 2"));
        offers.add(new Offer("Offer 3", R.drawable.offer_3, 249, "DOLLAR", "This is a description for offer 3"));
        return offers;
    }

}
