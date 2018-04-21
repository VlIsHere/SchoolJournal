package com.VladIndustries.Model;

import com.VladIndustries.MyExceptions.DateAlreadyExistException;
import com.VladIndustries.MyExceptions.MarkOutOfBoundsException;

import java.util.*;

public class Schoolboy {
    private String firstName;//имя
    private String surname;//фамилия
    private String patronymic;//отчество
    private ArrayList<Register> marksPerDay;//оценки по дате

    public Schoolboy(String firstName, String surname, String patronymic,int cntDaysForMarks) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.marksPerDay = new ArrayList<>(cntDaysForMarks);
        Calendar c = Calendar.getInstance();
        c.set(1996,10,4);//default 4November 1996
        for (int i = 0; i < cntDaysForMarks; i++) {
            marksPerDay.set(i,new Register(c,2));//default marks = 2
        }
    }

    public int getCount(){
        return marksPerDay.size();
    }

//return номер в массиве с указанной датой, если нет - вернёт -1
    private int containsData(Calendar date){
        Register tmp;
        for (int i = 0; i < marksPerDay.size(); i++) {
            tmp = marksPerDay.get(i);
            if (date.compareTo(tmp.date)==0){
                return i;
            }
        }
        return -1;
    }

//получение оценки по дате; если нет такой даты, то return -1
    public Integer getMark(Calendar date){
        return containsData(date);
    }

//изменение оценки по дате; если нет, то ничего; если оценка неправильная, то exception
    public void setMark(Calendar date,Integer mark) throws MarkOutOfBoundsException {
        if (mark>5 || mark<1) throw new MarkOutOfBoundsException();
        int tmp = containsData(date);
        if (tmp!=-1) {
            marksPerDay.set(tmp, new Register(date, mark));
        }
    }

    public void createMark(Calendar date,Integer mark) throws MarkOutOfBoundsException,DateAlreadyExistException {
        if (mark>5 || mark<1) throw new MarkOutOfBoundsException();
        if (containsData(date)!=-1) marksPerDay.add(new Register(date,mark));
        else throw new DateAlreadyExistException();
    }

//удалит 1ую запись с указанной датой
    public void removeMark(Calendar date){
        int tmp = containsData(date);
        if (tmp!=-1) marksPerDay.remove(tmp);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Schoolboy) {
            Schoolboy o = (Schoolboy) obj;
            if (o.getCount()==this.getCount() && firstName.equals(o.firstName) && surname.equals(o.surname) && patronymic.equals(o.patronymic)) {
                int i = 0;
                Register tmp;
                while (i<o.getCount()){
                    tmp = o.marksPerDay.get(i);
                    if (marksPerDay.get(i).mark!=tmp.mark || (marksPerDay.get(i).date.compareTo(tmp.date)!=0)){
                        break;
                    }
                    i++;
                }
                result = (i==o.getCount())? true:false;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,surname, patronymic, marksPerDay);
    }

    @Override
    public String toString() {
        return "Schoolboy:\nFirst name: " + firstName + "\nSurname: " +surname+"\nPatronymic: " + patronymic;
    }

    private class Register{//класс запись, в которой в определённую дату поставлена оценка
        private Calendar date;
        private Integer mark;

        public Register(Calendar date,int mark){
            this.mark = mark;
            this.date = date;
        }

        public Calendar getDate(){
            return date;
        }

        public void setDate(Calendar date){
            this.date = date;
        }

        public Integer getMark(){
            return mark;
        }

        public void setMark(Integer mark){
            this.mark = mark;
        }
    }
}
