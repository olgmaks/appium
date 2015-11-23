package com.epam.activity;

import com.epam.control.element.Button;
import com.epam.control.element.Label;
import com.epam.control.pageobject.AbstractActivity;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by OLEG on 22.11.2015.
 */
public class HomeActivity extends AbstractActivity {


    // Locators
    private static final String LEFT_MENU_SLIDER_ID = "img_sidebar";
    private static final String ADD_ITEM_BUTTON_ID = "main_btn1";
    private static final String OPTIONS_BUTTON_ID = "main_btn3";
    private static final String SORT_ORDER_DROP_DOWN_LIST_ID = "text_button_center";
    private static final String NOTE_LIST_GROUP_ID = "title";

    // Native elements

    @FindBy(id = LEFT_MENU_SLIDER_ID)
    private Button leftMenuSliderButton;

    @FindBy(id = ADD_ITEM_BUTTON_ID)
    private Button createNewItemButton;

    @FindBy(id = OPTIONS_BUTTON_ID)
    private Button optionsButton;

    @FindBy(id = SORT_ORDER_DROP_DOWN_LIST_ID)
    private Button sortOrderDropDownList;

    @FindBy(id = NOTE_LIST_GROUP_ID)
    private List<Label> notes;

    // Inner activities
    private NoteChoicePopOutActivity noteChoicePopOutActivity;
    private OptionMenuPopOutActivity optionMenuPopOutActivity;
    private SortOrderPopOutActivity sortOrderPopOutActivity;


    // Create new text note
    public CreateTextNoteActivity createNewTextNote() {

        createNewItemButton.click();

        if (noteChoicePopOutActivity == null)
            noteChoicePopOutActivity = new NoteChoicePopOutActivity();

        noteChoicePopOutActivity.selectTextNote();

        return new CreateTextNoteActivity();
    }


    // Create new check list
    public CreateCheckListActivity createCheckList() {

        createNewItemButton.click();

        if (noteChoicePopOutActivity == null)
            noteChoicePopOutActivity = new NoteChoicePopOutActivity();

        noteChoicePopOutActivity.selectCheckList();

        return new CreateCheckListActivity();
    }


    // Options pop out menu
    private OptionMenuPopOutActivity openOptionMenuPopOutActivity() {

        optionsButton.click();

        if (optionMenuPopOutActivity == null)
            optionMenuPopOutActivity = new OptionMenuPopOutActivity();

        return optionMenuPopOutActivity;
    }


    // Options pop out menu
    private SortOrderPopOutActivity sortOrderPopOutActivity() {

        sortOrderDropDownList.click();

        if (sortOrderPopOutActivity == null)
            sortOrderPopOutActivity = new SortOrderPopOutActivity();

        return sortOrderPopOutActivity;
    }


    public boolean verifyPresenceOfNoteByTitle (String title) {

        boolean result = false;

        for (Label note : notes) {
            if (note.getText().equals(title))
                result = true;
        }

        return result;
    }
}
