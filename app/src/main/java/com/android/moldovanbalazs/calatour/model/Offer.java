package com.android.moldovanbalazs.calatour.model;

public class Offer {

    public String title;
    public int image;
    public String priceCurrency;
    public int priceValue;
    public String description;

    public Offer(String title, int image, int priceValue, String priceCurrency, String description) {
        this.title = title;
        this.image = image;
        this.priceValue = priceValue;
        this.priceCurrency = priceCurrency;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public int getPriceValue() {
        return priceValue;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public String getDescription() {
        return description;
    }
}
