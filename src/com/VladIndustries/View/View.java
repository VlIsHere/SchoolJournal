package com.VladIndustries.View;

import com.VladIndustries.Model.Journal;
import com.VladIndustries.Model.SchoolGrade;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

public interface View {
    void initialize(File fileResult, File fileSerial, File fileInfo, OutputStream os, InputStream is);

    void start();

    void destroy();

    String inputFIO();

    Calendar inputDate();

    int inputMark();

    int askUser();

    int inputNumGrade();

    char inputLetter();

    Journal selectJournal(SchoolGrade scg);

    boolean menuMethods(int numb);

    void printMenu();
}
