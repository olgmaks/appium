package com.epam.testdata.dataprovider;

import com.epam.model.CheckList;
import com.epam.model.Note;
import com.epam.testdata.xlsparser.XLSParser;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Oleh_Maksymuk on 11/23/2015.
 */
public class Data {

    private static List<Note> notes;

    private static List<CheckList> checkLists;


    public static List<Note> getNoteListTestData() {

        if (notes != null)
            return notes;

        XLSParser<Note> noteXLSParser = new XLSParser<>(Note.class, "src/main/resources/notes.xlsx");

        return noteXLSParser.getAll();

    }

    public static List<CheckList> getCheckListTestData() {

        if (checkLists != null)
            return checkLists;


        CheckList checkListOne = new CheckList();

        checkListOne.setTitle("First Check list");

        checkListOne.setItems(Arrays.asList(new String[]{"Buy milk", "Buy salt", "Buy water", "Drop garbage"}));


        CheckList checkListTwo = new CheckList();

        checkListTwo.setTitle("Second Check list");

        checkListTwo.setItems(Arrays.asList(new String[]{"First task", "Second task"}));


        CheckList checkListThree = new CheckList();

        checkListThree.setTitle("Third Check list");

        checkListThree.setItems(Arrays.asList(new String[]{"First task", "Second task", "Third task"}));

        checkLists = Arrays.asList(new CheckList[]{checkListOne, checkListTwo, checkListThree});

        return checkLists;

    }


}
