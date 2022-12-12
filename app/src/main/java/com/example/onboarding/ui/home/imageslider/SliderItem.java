package com.example.onboarding.ui.home.imageslider;

public class SliderItem {

    private String description;
    private String place;

    private int imageUrl;

    public SliderItem(String place,String description, int imageUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.place=place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlace() {
        return place;
    }

    public void setPlace(String description) {
        this.place = place;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}