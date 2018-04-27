package com.VladIndustries.Model;

import java.io.Serializable;
import java.util.Objects;

public class Pupil implements Serializable{
    private static final String NO_NAME = "NO_NAME";
    private static final long serialVersionUID = -1011245132329653108L;
    private String firstName;//имя
    private String surname;//фамилия
    private String patronymic;//отчество
   // private ArrayList<Register> marksPerDay;//оценки по дате

    Pupil(){
        this.firstName = NO_NAME;
        this.surname = NO_NAME;
        this.patronymic = NO_NAME;
       // this.marksPerDay = new ArrayList<>();
    }

    public Pupil(String firstName, String surname, String patronymic){//, int cntDaysForMarks) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
       // this.marksPerDay = new ArrayList<>(cntDaysForMarks);
//        Calendar c = Calendar.getInstance();
//        c.set(1996,Calendar.NOVEMBER,4);//default 4November 1996
//        for (int i = 0; i < cntDaysForMarks; i++) {
//            c.set(1996,Calendar.NOVEMBER,(int)(Math.random()*11));
//            marksPerDay.add(i,new Register(c,(int)(Math.random()*4+1)));//default marks = 2
//        }
    }

//    public int getCount(){
//        return marksPerDay.size();
//    }
//
//    public void sortByDate(){
//        Collections.sort(marksPerDay, Comparator.comparing(Register::getDate));
//    }
//
////получение оценки по дате; если нет такой даты, то return -1
//    public Integer getMark(Calendar date){
//        return findRegistersByDate(date);
//    }

//    public int getMark(int numb){
//        if (numb<marksPerDay.size() && numb>=0) {
//            return marksPerDay.get(numb).mark;
//        }else return -1;
//    }

//    public Calendar getDate(int numb){
//        if (numb<marksPerDay.size() && numb>=0) {
//            return marksPerDay.get(numb).date;
//        }else return null;
//    }
//
////изменение оценки по дате; если нет, то ничего; если оценка неправильная, то exception
//    public void setMark(Calendar date,Integer mark) throws MarkOutOfBoundsException {
//        if (mark>5 || mark<1) throw new MarkOutOfBoundsException();
//        int tmp = findRegistersByDate(date);
//        if (tmp!=-1) {
//            marksPerDay.get(tmp).setMark(mark);
//        }
//    }
//
//    public void setMark(int numb, int mark){
//        if (numb<marksPerDay.size() && numb>=0) {
//            marksPerDay.get(numb).setMark(mark);
//        }
//    }
//
//    public void createRegister(Calendar date, Integer mark) throws MarkOutOfBoundsException,DateAlreadyExistException {
//        if (mark>5 || mark<1) throw new MarkOutOfBoundsException();
//        if (findRegistersByDate(date)!=-1) marksPerDay.add(new Register(date,mark));
//        else throw new DateAlreadyExistException();
//    }
//
////удалит 1ую запись с указанной датой
//    public void removeRegister(Calendar date){
//        int tmp = findRegistersByDate(date);
//        if (tmp!=-1) marksPerDay.remove(tmp);
//    }

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

//    @Override
//    public boolean equals(Object obj) {
//        boolean result = false;
//        if (obj instanceof Pupil) {
//            Pupil o = (Pupil) obj;
//            if (o.getCount()==this.getCount() && firstName.equals(o.firstName) && surname.equals(o.surname) && patronymic.equals(o.patronymic)) {
//                int i = 0;
//                Register tmp;
//                while (i<o.getCount()){
//                    tmp = o.marksPerDay.get(i);
//
//                    if (marksPerDay.get(i).mark!=tmp.mark || (marksPerDay.get(i).date.getTime().equals(tmp.date))){//marksPerDay.get(i).date.compareTo(tmp.date)!=0)){
//                        break;
//                    }
//                    i++;
//                }
//                result = i==o.getCount();
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName,surname, patronymic);//, marksPerDay);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return Objects.equals(firstName.toUpperCase(), pupil.firstName.toUpperCase()) &&
                Objects.equals(surname.toUpperCase(), pupil.surname.toUpperCase()) &&
                Objects.equals(patronymic.toUpperCase(), pupil.patronymic.toUpperCase());
    }

    @Override
    public int hashCode() {return Objects.hash(firstName, surname, patronymic);}

    @Override
    public String toString() {
        return "Pupil{" + "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' + '}';
    }

    //    @Override
//    public String toString() {
//        String s = "PUPIL:\nFirst name: " + firstName + "\nSurname: " +surname+"\nPatronymic: " + patronymic + "\n";
//        for (int i = 0; i < marksPerDay.size(); i++) {
//            s+= marksPerDay.get(i).date.getTime().toString() + " - " + marksPerDay.get(i).mark + "\n";
//        }
//        return s;
//    }

//    //return номер в массиве с указанной датой, если нет - вернёт -1
//    private int findRegistersByDate(Calendar date){
//        Register tmp;
//        for (int i = 0; i < marksPerDay.size(); i++) {
//            tmp = marksPerDay.get(i);
//            if (date.getTime().equals(tmp.date)){
//                return i;
//            }
//        }
//        return -1;
//    }

//    private class Register implements Serializable{//класс запись, в которой в определённую дату поставлена оценка
//        private static final long serialVersionUID = -5882092467075653443L;
//        private Calendar date;
//        private Integer mark;
//
//        Register(Calendar date,int mark){
//            this.mark = mark;
//            this.date = date;
//        }
//
//        //объект урок, в кот будет дата и список учеников, посещающих занятия
//        public Calendar getDate(){
//            return date;
//        }
//
//        public void setDate(Calendar date){
//            this.date = date;
//        }
//
//        public Integer getMark(){
//            return mark;
//        }
//
//        public void setMark(Integer mark){
//            this.mark = mark;
//        }
//    }
}
