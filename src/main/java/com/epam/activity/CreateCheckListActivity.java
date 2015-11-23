package com.epam.activity;

import com.epam.control.element.Button;
import com.epam.control.element.TextField;
import com.epam.control.engine.Drivers;
import com.epam.control.pageobject.AbstractActivity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by OLEG on 22.11.2015.
 */
public class CreateCheckListActivity extends AbstractActivity{

    //Locators

    private static final String ADD_LIST_ITEM_XPATH = "//android.widget.ListView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/editlist']/android.widget.LinearLayout";
    private static final String ADD_LAST_LIST_ITEM_BUTTON_XPATH = ADD_LIST_ITEM_XPATH + "[last()]";
    private static final String ADD_FIRST_LIST_ITEM_BUTTON_XPATH = ADD_LIST_ITEM_XPATH + "[1]";
    private static final String CHECK_LIST_NAME_FIELD = "edit";
    private static final String CHECK_LIST_ITEM_SUBMIT_BUTTON = "button1";
    private static final String CHECK_LIST_ITEM_TITLE_FIELD = "edit_title";

    //Elements
    @FindBy(id = CHECK_LIST_ITEM_TITLE_FIELD)
    private TextField checkListTitleField;

    @FindBy(xpath = ADD_FIRST_LIST_ITEM_BUTTON_XPATH)
    private Button addFirstListItemButton;

    @FindBy(xpath = ADD_LAST_LIST_ITEM_BUTTON_XPATH)
    private Button addLastListItemButton;




    // Create new item check list
    @FindBy(id = CHECK_LIST_NAME_FIELD)
    private TextField newListItemDescriptionField;

    @FindBy(id = CHECK_LIST_ITEM_SUBMIT_BUTTON)
    private Button submitNewListItemButton;




    public void typeTitle(String titleText) {
        checkListTitleField.setText(titleText);
    }


    private void setTextAndClickOk(String description) {
        newListItemDescriptionField.setText(description);
        submitNewListItemButton.click();
    }


    public void addFirstListItem(String description) {


        addFirstListItemButton.click();

        setTextAndClickOk(description);
    }


    public void addLastListItem(String description) {


        addLastListItemButton.click();

        setTextAndClickOk(description);
    }


    public HomeActivity backToHome() {

        Drivers.previousPage();
        Drivers.previousPage();

        return new HomeActivity();
    }
}
