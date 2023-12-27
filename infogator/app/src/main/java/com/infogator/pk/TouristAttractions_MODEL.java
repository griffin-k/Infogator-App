package com.infogator.pk;

public class TouristAttractions_MODEL {
    int image;
    String name, state;

    public TouristAttractions_MODEL(int image, String name, String state) {
        this.image = image;
        this.name = name;
        this.state = state;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
