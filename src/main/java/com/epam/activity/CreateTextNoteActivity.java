package com.epam.activity;

import com.epam.control.element.TextField;
import com.epam.control.engine.Drivers;
import com.epam.control.pageobject.AbstractActivity;
import org.openqa.selenium.support.FindBy;

/**
 * Created by OLEG on 22.11.2015.
 */
public class CreateTextNoteActivity extends AbstractActivity{


    private static final String NOTE_TITLE_ID = "edit_title";
    private static final String NOTE_BODY_ID = "edit_note";


    @FindBy(id = NOTE_TITLE_ID)
    private TextField noteTitleField;

    @FindBy(id = NOTE_BODY_ID)
    private TextField noteBodyField;



    public void typeTitle(String titleText) {
        noteTitleField.setText(titleText);
    }


    public void typeBody(String bodyText) {
        noteBodyField.setText(bodyText);
    }


    public HomeActivity backToHome() {

        Drivers.previousPage();
        Drivers.previousPage();

        return new HomeActivity();
    }


}
