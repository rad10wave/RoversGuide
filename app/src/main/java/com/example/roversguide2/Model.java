package com.example.roversguide2;

public class Model {
    int image;
    String state_name;

    public Model(int image, String state_name) {
        this.image = image;
        this.state_name = state_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }


}
