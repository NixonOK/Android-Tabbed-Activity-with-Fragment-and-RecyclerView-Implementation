package com.w3e.nixonok.androidbasicsassignment;

/**
 * Created by Sudarshan on 2/15/2018.
 */

public class Item {


    private int image;
    private String title;
    private String description;

    public Item() {
    }

    public Item(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}