package com.VladIndustries.Model;

import com.VladIndustries.MyExceptions.DateAlreadyExistException;
import com.VladIndustries.MyExceptions.MarkOutOfBoundsException;
import com.VladIndustries.MyExceptions.PupilAlreadyExistException;
import javafx.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public abstract class Journal implements Serializable {
    protected ArrayList<Pupil> pupils;//список учеников
    protected String teacherFIO;
    protected ArrayList<Pair<Calendar,ArrayList<Pupil>>> lessons;//массив пар дата - список ответивших(состоявшийся урок)

    public Journal(PhysicsJournal sj){
        this.teacherFIO = sj.teacherFIO;
        this.pupils = new ArrayList<>(sj.getSchoolBoysCnt());
        for (int i = 0; i < sj.getSchoolBoysCnt(); i++) {
            pupils.set(i,sj.pupils.get(i));
        }
        this.lessons = new ArrayList<>(sj.getLessonsSize());
        for (int i = 0; i < sj.getLessonsSize(); i++) {
            lessons.set(i,sj.getPair(i));
        }
    }

    public Journal(String teacherFIO,int cntScBoys,int cntLessons){
        this.teacherFIO = teacherFIO;
        this.pupils = new ArrayList<>(cntScBoys);
        this.lessons = new ArrayList<>(cntLessons);
//        for (int i = 0; i < countScBoys; i++) {
//            pupils.add(i,new Pupil());
//        }
    }

    public Pair<Calendar,ArrayList<Pupil>> getPair(int numb){
        return lessons.get(numb);
    }

    public void addPair(Calendar date,ArrayList<Pupil> pupils) throws DateAlreadyExistException {
        int numb = containsDate(date);
        if (numb==-1) throw new DateAlreadyExistException();
        lessons.add(new Pair<>(date,pupils));
    }

    public int getLessonsSize(){
        return lessons.size();
    }

    //добавление оценки
    public abstract void addMark(Pupil p, Calendar date, int mark) throws PupilAlreadyExistException, MarkOutOfBoundsException, DateAlreadyExistException;

    //удаление оценки по дате
    public abstract void removeMark(Pupil p,Calendar date) throws PupilAlreadyExistException;
    //изменение оценки
    public abstract void setMark(Pupil p,Calendar date, int mark) throws MarkOutOfBoundsException, PupilAlreadyExistException;

    //поиск
    public int findPupil(Pupil p){
        for (int i = 0; i < pupils.size(); i++) {
            if (pupils.get(i).equals(p)) return i;
        }
        return -1;
    }

    //удаление
    public abstract void removePupil(Pupil pupil);

    //изменение
    public abstract void setPupil(Pupil newp, Pupil oldp) throws PupilAlreadyExistException;

    //добавление
    public abstract void addPupil(Pupil pupil) throws PupilAlreadyExistException;

    public int getSchoolBoysCnt() {
        return pupils.size();
    }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Journal that = (Journal) o;
            return Objects.equals(pupils, that.pupils) &&
                    Objects.equals(lessons, that.lessons) &&
                    Objects.equals(teacherFIO, that.teacherFIO);
        }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
        public String toString() {
            String res ="SchoolJournal{" + ", subject=" + this.getClass().getName() + '\'' +
                    ", teacherFIO=" + teacherFIO + '\'' + "pupils= " ;
            for (int i = 0; i < pupils.size(); i++) {
                res+=pupils.toString() + "\n";
            }
            return res;
        }

        protected int containsDate(Calendar date){
            for (int i = 0; i < lessons.size(); i++) {
                if (date.getTime().equals(lessons.get(i).getKey())){
                    return i;
                }
            }
            return -1;
        }
}
