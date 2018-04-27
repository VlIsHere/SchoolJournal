package com.VladIndustries.View;

import com.VladIndustries.Checker;
import com.VladIndustries.Model.Journal;
import com.VladIndustries.Model.Pupil;
import com.VladIndustries.Model.SchoolGrade;
import com.VladIndustries.MyExceptions.GradeDoesntExistException;
import com.VladIndustries.MyExceptions.JournalDoesntExistInGradeException;
import com.VladIndustries.MyExceptions.MarkOutOfBoundsException;
import com.VladIndustries.MyExceptions.PupilDoesntExistInGradeException;
import com.VladIndustries.Presenter;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ViewConsole implements View {
    private Presenter presenter;
    private PrintWriter writeConsole;
    private PrintWriter writeFile;
    private Scanner reader;
    private File fileResult;
    private Checker checker;

    public void initialize(File fileResult,File fileSerial,File fileInfo, OutputStream os, InputStream is){
        checker = new Checker();
        this.fileResult = fileResult;
        presenter = new Presenter(fileSerial);
        writeConsole = new PrintWriter(os,true);
        writeConsole.println("Инициализация...");
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
        writeConsole.println("Читаем данные...");
       // presenter.initialize();
      //  presenter.serialSchlGrade(presenter.getFileSerial());
        presenter.deserialSchlGrade(presenter.getFileSerial());//then save this changed arr in result file
        writeConsole.print(presenter.getSchoolGradesToString());
        do {
            printMenu();
        }while (menuMethods(askUser()));
    }

    public void destroy(){
        presenter.serialSchlGrade(fileResult);
        writeConsole.println("Завершение работы...");
        reader.close();
        writeConsole.close();
        writeFile.close();
    }

    public String inputFIO(){
        String fio = null;
        do {
            writeConsole.println("Введите ФИО:");
            fio = reader.nextLine();
        }while (!checker.checkFIO(fio));
        return fio;
    }

    public Calendar inputDate(){
        Calendar c = new GregorianCalendar();
        String s = null;
        do {
            writeConsole.println("Введите дату в формате \"ЧЧ:ММ:ГГГГ\"");
            s = reader.nextLine();
        }while (!checker.checkDate(s));
        String[] spl = s.split(":");
        int month = Integer.parseInt(spl[1])-1;
        c.set(Integer.parseInt(spl[2]),month,Integer.parseInt(spl[0]));//тк Январь - 0ой месяц0
        return c;
    }

    public int inputMark(){
        String s = null;
        do {
            writeConsole.println("Введите оценку:");
            s = reader.nextLine();
        }while (!checker.checkMark(s));
        return Integer.parseInt(s);
    }

    public int askUser(){
        String s = null;
        do {
            writeConsole.println("Введите команду:");
            s = reader.nextLine();
        }while (!checker.checkMenuChoice(s));
        return Integer.parseInt(s);
    }

    public int inputNumGrade(){
        String s = null;
        do {
            writeConsole.println("Введите № Класса:");
            s = reader.nextLine();
        }while (!checker.checkNumGrade(s));
        return Integer.parseInt(s);
    }

    public char inputLetter(){
        String s = null;
        do {
            writeConsole.println("Введите букву класса(используя русскую раскладку!):");
            s = reader.nextLine();
        }while (!checker.checkLetter(s));
        return  s.toUpperCase().charAt(0);
    }

    public Journal selectJournal(SchoolGrade scg){
        String s;
        Journal j = null;
        do {
            writeConsole.println("Введите название предмета:");
            s = reader.nextLine();
            j= presenter.getJournalByName(scg,s);
        }while ( j==null);
        return j;
    }

    public boolean menuMethods(int numb){
        if (numb == 0) return false;
        SchoolGrade scg;
        int numGrade;
        char letter;
        int mark;
        do {
            numGrade = inputNumGrade();
             letter = inputLetter();
            scg = presenter.getSchoolGrade(letter, numGrade);
        }while (scg==null);
        Journal j = selectJournal(scg);
        Calendar c = inputDate();
        String fio = inputFIO();
        String fio2[] = fio.split(" ");;
        try {
            switch (numb){
                case 1:
                    mark =inputMark();
                    writeFile.println(LocalDateTime.now() + " try to add mark: " + mark + "in SchoolGrade: "
                            + numGrade + letter + "in Journal: " + j.getNameSubject() + ", teacher - "
                            + j.getTeacherFIO() + "; Date = " +c.getTime() + "for Pupil - " + fio);
                    if (presenter.addMarkByDate(numGrade,letter,j,c,new Pupil(fio2[0],fio2[1],fio2[2]),mark)) {
                        writeFile.println("success");
                    }
                    break;//"1) Добавление оценки");
                case 2:
                    writeFile.println(LocalDateTime.now() + " try to remove mark in SchoolGrade: " + numGrade
                            + letter + "in Journal: " + j.getNameSubject() + ", teacher - " + j.getTeacherFIO()
                            + "; Date = " +c.getTime() + "for Pupil - " + fio);
                    if (presenter.removeMarkByDate(numGrade,letter,j,c,new Pupil(fio2[0],fio2[1],fio2[2]))){
                        writeFile.println("success");
                    }
                    break; //"2) Удаление оценки");
                case 3:
                    mark =inputMark();
                    writeFile.println(LocalDateTime.now() + " try to set mark for this: " + mark + "in SchoolGrade: "
                            + numGrade + letter + "in Journal: " + j.getNameSubject() + ", teacher - "
                            + j.getTeacherFIO() + "; Date = " +c.getTime() + "for Pupil - " + fio);
                    if (presenter.setMarkByDate(numGrade,letter,j,c,new Pupil(fio2[0],fio2[1],fio2[2]),mark)){
                        writeFile.println("success");
                    }
                    break;//"3) Изменение оценки");
                default:
                    return false;
            }
        } catch (GradeDoesntExistException | JournalDoesntExistInGradeException |PupilDoesntExistInGradeException |MarkOutOfBoundsException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void printMenu(){
        writeConsole.println("Методы изменения данных:");
        writeConsole.println("0) Завершить работу");
        writeConsole.println("1) Добавление оценки");
        writeConsole.println("2) Удаление оценки");
        writeConsole.println("3) Изменение оценки");
    }
}
