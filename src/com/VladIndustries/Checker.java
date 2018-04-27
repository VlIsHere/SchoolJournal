package com.VladIndustries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker{
    private final Pattern date = Pattern.compile("^(0[1-9]|1[0-9]|2[0-9]|3[01]):(0[1-9]|1[012]):[0-9]{4}$");//DD:MM:YYYY
    private final Pattern fio = Pattern.compile("^([А-ЯЁ][а-яё]+[\\-\\s]?){3}$");
    private final Pattern numForMenu = Pattern.compile("^[0-3]$");
    private final Pattern mark = Pattern.compile("^[1-5]$");
    private final Pattern numGrade = Pattern.compile("^[1-9][0-1]?$");
    private final Pattern letter = Pattern.compile("^[А-Я]|[а-я]$");
   // private final Pattern number = Pattern.compile("^\\d+$");

    public boolean checkNumGrade(String s){
        Matcher m = numGrade.matcher(s);
        return m.matches();
    }

    public boolean checkLetter(String s){
        Matcher m = letter.matcher(s);
        return m.matches();
    }

    public boolean checkDate(String s){
        Matcher m = date.matcher(s);
        return m.matches();
    }

    public boolean checkFIO(String s){
        Matcher m = fio.matcher(s);
        return m.matches();
    }

    public boolean checkMark(String s){
        Matcher m = mark.matcher(s);
        return m.matches();
    }

    public boolean checkMenuChoice(String s){
        Matcher m = numForMenu.matcher(s);
        return m.matches();
    }
}
