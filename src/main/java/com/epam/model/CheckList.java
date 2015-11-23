package com.epam.model;

import java.util.List;

/**
 * Created by Oleh_Maksymuk on 11/23/2015.
 */
public class CheckList {


    private String title;

    private List<String> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
