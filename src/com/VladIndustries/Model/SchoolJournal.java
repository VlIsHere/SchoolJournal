package com.VladIndustries.Model;

import com.VladIndustries.MyExceptions.DateAlreadyExistException;
import com.VladIndustries.MyExceptions.MarkOutOfBoundsException;
import com.VladIndustries.MyExceptions.PupilAlreadyExistException;

import java.util.ArrayList;
import java.util.Calendar;

public class SchoolJournal {
    private ArrayList<Pupil> pupils;
    private String subject;
    private String teacherFIO;

    public SchoolJournal(String teacherFIO,String subject,int countScBoys){
        this.teacherFIO = teacherFIO;
        this.subject = subject;
        this.pupils = new ArrayList<>(countScBoys);
        for (int i = 0; i < countScBoys; i++) {
            pupils.set(i,new Pupil());
        }
    }

    //добавление оценки
    public void addMark(Pupil p, Calendar date, int mark) throws PupilAlreadyExistException, MarkOutOfBoundsException, DateAlreadyExistException {
        int numb = findPupil(p);
        if (numb!=-1) throw new PupilAlreadyExistException();
        pupils.get(numb).createMark(date,mark);
    }

    //удаление оценки по дате
    public void removeMark(Pupil p,Calendar date) throws PupilAlreadyExistException {
        int numb = findPupil(p);
        if (numb!=-1) throw new PupilAlreadyExistException();
        pupils.get(numb).removeMark(date);
    }

    //изменение оценки
    public void setMark(Pupil p,Calendar date, int mark) throws MarkOutOfBoundsException, PupilAlreadyExistException {
        int numb = findPupil(p);
        if (numb!=-1) throw new PupilAlreadyExistException();
        pupils.get(numb).setMark(date,mark);
    }

//поиск
    public int findPupil(Pupil p){
        for (int i = 0; i < pupils.size(); i++) {
            if (pupils.get(i).equals(p)) return i;
        }
        return -1;
    }

//удаление
    public void removePupil(Pupil pupil){
        if (pupils.contains(pupil)) pupils.remove(pupil);
    }

//изменение
    public void setPupil(Pupil newp, Pupil oldp) throws PupilAlreadyExistException {
        int numb = findPupil(newp);
        if (numb==-1) throw new PupilAlreadyExistException();
        pupils.set(numb,newp);
    }

//добавление
    public void addPupil(Pupil pupil) throws PupilAlreadyExistException {
        if (pupils.contains(pupil)) throw new PupilAlreadyExistException();
        pupils.add(pupil);
    }

    public String getTeacherFIO() {
        return teacherFIO;
    }

    public void setTeacherFIO(String teacherFIO) {
        this.teacherFIO = teacherFIO;
    }

    public int getSchoolBoysCnt() {
        return pupils.size();
    }

    public Pupil getSchoolBoy(int numb) {
        return pupils.get(numb);
    }

    public void setPupils(ArrayList<Pupil> pupils) {
        this.pupils = pupils;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
