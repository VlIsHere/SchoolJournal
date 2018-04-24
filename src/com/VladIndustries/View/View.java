package com.VladIndustries.View;

import com.VladIndustries.Presenter;

import java.io.*;
import java.util.Scanner;

public class View {
    private Presenter presenter;
    private PrintWriter writeConsole;
    private PrintWriter writeFile;
    private Scanner reader;

    public void initialize(File fileSerial,File fileInfo, OutputStream os, InputStream is){
        presenter = new Presenter(fileSerial);
        writeConsole = new PrintWriter(os);
        try {
            writeFile = new PrintWriter(fileInfo);
        } catch (FileNotFoundException e) {
            try {
                fileInfo.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        reader = new Scanner(is);
    }

    public void start(){
        writeConsole.println("Инициализация...");
       presenter.serialSchlGrade(presenter.getFileSerial(),presenter.initialize());
       // SchoolGrade[] sc = presenter.deserialSchlGrade(presenter.getFileSerial());
        writeConsole.println();

    }

    public void destroy(){
        reader.close();
        writeConsole.close();
        writeFile.close();
    }

    public void printResult(){

    }
}
