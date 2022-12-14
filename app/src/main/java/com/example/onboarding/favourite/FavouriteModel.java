package com.example.onboarding.favourite;

public class FavouriteModel {
    int img;
    String name;
    String address;

    public FavouriteModel(int img, String name, String address) {
        this.img = img;
        this.name = name;
        this.address = address;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}