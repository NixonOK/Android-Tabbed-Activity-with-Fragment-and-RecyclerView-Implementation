package com.w3e.nixonok.androidbasicsassignment;

import java.util.ArrayList;

/**
 * Created by Sudarshan on 2/16/2018.
 */

public class Section {
    private String title;
    private ArrayList<Item> item;

    public Section(String title, ArrayList<Item> item) {
        this.title = title;
        this.item = item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }
}
