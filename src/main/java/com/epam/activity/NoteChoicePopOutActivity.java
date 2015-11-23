package com.epam.activity;

import com.epam.control.eagerlocator.Buttons;
import com.epam.control.element.Button;

public class NoteChoicePopOutActivity {


    private static final String MENU_ITEM_UI_AUTOMATOR =
            "new UiSelector()." +
                    "resourceId(\"android:id/select_dialog_listview\")." +
                    "childSelector(className(\"android.widget.LinearLayout\").index(%s))";



    private Button addNoteSelect;
    private Button addCheckListSelect;


    public NoteChoicePopOutActivity() {

        addNoteSelect = Buttons.byUIAutomator(String.format(MENU_ITEM_UI_AUTOMATOR, 0));

        addCheckListSelect = Buttons.byUIAutomator(String.format(MENU_ITEM_UI_AUTOMATOR, 1));

    }


    public void selectCheckList() {
        addCheckListSelect.click();
    }


    public void selectTextNote() {
        addNoteSelect.click();
    }


}