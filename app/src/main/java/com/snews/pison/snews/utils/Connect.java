package com.snews.pison.snews.utils;

/**
 * Created by Olusegun Olaosebikan on 2/18/2016.
 * Class used to set values for the selection page(cardview)
 */
public class Connect {
    private int image_id;
    private String name;

    public Connect(int image_id, String name){
        this.image_id = image_id;
        this.name = name;

    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
