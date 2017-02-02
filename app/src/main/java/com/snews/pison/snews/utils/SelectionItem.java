package com.snews.pison.snews.utils;

/**
 * Created by Olusegun Olaosebikan on 2/18/2016.
 * Class used to set values for the selection page(cardview)
 */
public class SelectionItem {
    private int image_id;
    private String name;
    private int background_id;

    public SelectionItem(int image_id, String name, int background_id){
        this.image_id = image_id;
        this.name = name;
        this.setBackground_id(background_id);
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


    public int getBackground_id() {
        return background_id;
    }

    public void setBackground_id(int background_id) {
        this.background_id = background_id;
    }
}
