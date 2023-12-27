package com.infogator.pk.AllTourAttractions;

public class TourAttractionsList_Model {

    String city, state;
    int image;

    public TourAttractionsList_Model(String city, String state, int image) {
        this.city = city;
        this.state = state;
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
