package com.epam.test;

import com.epam.activity.CreateCheckListActivity;
import com.epam.activity.CreateTextNoteActivity;
import com.epam.activity.HomeActivity;
import com.epam.model.CheckList;
import com.epam.model.Note;
import com.epam.testdata.dataprovider.Data;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/**
 * Created by OLEG on 22.11.2015.
 */
public class ColorNotesTest {

    private static List<Note> notes = null;
    private static List<CheckList> checkLists = null;

    @Test
    public void testLogin() throws Exception {


        HomeActivity homeActivity = new HomeActivity();


        // Creating single note

        CreateTextNoteActivity createTextNoteActivity;


        for (Note note : notes) {

            createTextNoteActivity = homeActivity.createNewTextNote();

            createTextNoteActivity.typeTitle(note.getTitle());
            createTextNoteActivity.typeBody(note.getBody());

            homeActivity = createTextNoteActivity.backToHome();
        }



        // Creating check list

        CreateCheckListActivity createCheckListActivity;


        for (CheckList checkListItem : checkLists) {

            createCheckListActivity  = homeActivity.createCheckList();

            createCheckListActivity.typeTitle(checkListItem.getTitle());


            for (String item: checkListItem.getItems()) {

                if (new Random().nextBoolean()) {

                    createCheckListActivity.addFirstListItem(item);

                } else {

                    createCheckListActivity.addLastListItem(item);
                }
            }

            homeActivity = createCheckListActivity.backToHome();
        }



        for (Note note : notes)
            Assert.assertTrue(homeActivity.verifyPresenceOfNoteByTitle(note.getTitle()));

        for (CheckList checkList : checkLists)
            Assert.assertTrue(homeActivity.verifyPresenceOfNoteByTitle(checkList.getTitle()));



    }


    @BeforeClass
    public static void setUp() throws Exception {

        //Setting up testing data

        notes = Data.getNoteListTestData();
        checkLists = Data.getCheckListTestData();
    }


    @AfterClass
    public void tearDown() throws Exception {


    }
}
