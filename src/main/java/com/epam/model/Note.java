package com.epam.model;

import com.epam.testdata.xlsparser.KeyLabel;

/**
 * Created by Oleh_Maksymuk on 11/23/2015.
 */
public class Note {


    @KeyLabel("note_title")
    private String title;

    @KeyLabel("note_body")
    private String body;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
