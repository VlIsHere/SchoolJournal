package com.VladIndustries.Model;

import com.VladIndustries.MyExceptions.MarkOutOfBoundsException;
import javafx.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public abstract class Journal implements Serializable {
    protected String teacherFIO;
    protected ArrayList<Pair<Calendar, ArrayList<Register>>> lessons;//массив пар дата - список ответивших(состоявшийся урок)

    public Journal(Journal sj) {
        this.teacherFIO = sj.teacherFIO;
//        this.pupils = new ArrayList<>(sj.getSchoolBoysCnt());
//        for (int i = 0; i < sj.getSchoolBoysCnt(); i++) {
//            pupils.set(i, sj.pupils.get(i));
//        }
        this.lessons = new ArrayList<>(sj.getLessonsSize());
        for (int i = 0; i < sj.getLessonsSize(); i++) {
            lessons.set(i, sj.lessons.get(i));
        }
    }

    public Journal(String teacherFIO, int cntLessons) {
        this.teacherFIO = teacherFIO;
      //  this.pupils = new ArrayList<>(cntScBoys);
        this.lessons = new ArrayList<>(cntLessons);
//        Calendar c = Calendar.getInstance();
//        for (int i = 0; i < cntLessons; i++) {
//            c.set(1996,Calendar.NOVEMBER,(int)(Math.random()*11));
//            lessons.add(new Pair<>(c,new ArrayList<>()));
//        }
//        for (int i = 0; i < countScBoys; i++) {
//            pupils.add(i,new Pupil());
//        }
    }

//    public Pair<Calendar, ArrayList<Register>> getPair(int numb) {
//        return lessons.get(numb);
//    }
//
//    public void addPair(Calendar date, ArrayList<Register> registers) throws DateAlreadyExistException {
//        int numb = findRegistersByDate(date);
//        if (numb == -1) throw new DateAlreadyExistException();//todo иногда преподы ставили в 1 и ту же графу оценки, но у меня 1 дата - 1 оценка
//        lessons.add(new Pair<>(date, registers));
//    }
//
//    public void setPair(Calendar date, Pair<Calendar, ArrayList<Register>> pair) {
//        int numb = findRegistersByDate(date);
//        if (numb != -1) lessons.set(numb, pair);
//    }

    public abstract String getNameSubject();

    public int getLessonsSize() {
        return lessons.size();
    }

//поиск записи по дате и ученику(res[0] = номер в lessons, res[1] = номер в registers )
    public int[] findRegister(Calendar date, Pupil p){
        int[] res = new int[2];
        res[0] = findRegistersByDate(date);
        res[1] = -1;
        ArrayList<Register> regs = lessons.get(res[0]).getValue();
        for (int i = 0; i < regs.size(); i++) {
            if (p.equals(regs.get(i).pupil)) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    //добавление записи c оценкой в определ. дату!!!)
    public boolean addRegister(Calendar date, Pupil p, int mark) throws MarkOutOfBoundsException {
        int numb = findRegistersByDate(date);
        if (numb==-1) {//if no date in lessons like 'date' above
            lessons.add(new Pair<>(date,new ArrayList<>()));
           return lessons.get(lessons.size()-1).getValue().add(new Register(p,mark));
        }else {
           return lessons.get(numb).getValue().add(new Register(p,mark));//если ученик, кот пришёл на урок есть в списке журнала
        }
    }
//    public void addMark(Pupil p, Calendar date, int mark) throws PupilAlreadyExistException, MarkOutOfBoundsException, DateAlreadyExistException {
//        int numb = findPupil(p);
//        if (numb != -1) throw new PupilAlreadyExistException();
//        pupils.get(numb).createRegister(date, mark);
//    }

    //удаление ЗАПИСИ оценки по дате
    public boolean removeRegister(Calendar date,Pupil p){
        int[] numbs = findRegister(date,p);
        if (numbs[0]!=-1 && numbs[1]!=-1) {
           lessons.get(numbs[0]).getValue().remove(numbs[1]);
           return true;
        }else return false;
    }
//    public void removeMark(Register register, Calendar date) throws PupilAlreadyExistException {
//        int numb = findPupil();
//        if (numb != -1) lessons.get(numb).getValue().;
//    }

    //изменение оценки в записи
    public boolean setRegister(Calendar date,Pupil p,int mark) throws MarkOutOfBoundsException {
        int[] numbs = findRegister(date,p);
        if (numbs[0]!=-1 && numbs[1]!=-1) {
            lessons.get(numbs[0]).getValue().set(numbs[1],new Register(p,mark));
            return true;
        }else return false;
    }
//    public void setMark(Pupil p, Calendar date, int mark) throws MarkOutOfBoundsException, PupilAlreadyExistException {
//        int numb = findPupil(p);
//        if (numb != -1) throw new PupilAlreadyExistException();
//        pupils.get(numb).setMark(date, mark);
//    }


//    //поиск по списку учеников
//    public int findPupil(Pupil p) {
//        for (int i = 0; i < pupils.size(); i++) {
//            if (pupils.get(i).equals(p)) return i;
//        }
//        return -1;
//    }
//
//    //удаление ученика
//    public void removePupil(Pupil pupil) {
//        if (pupils.contains(pupil)) pupils.remove(pupil);
//    }
//
//    //изменение ученика
//    public void setPupil(Pupil newp, Pupil oldp) throws PupilAlreadyExistException {
//        int numb = findPupil(newp);
//        if (numb == -1) throw new PupilAlreadyExistException();
//        pupils.set(numb, newp);
//    }
//
//    //добавление ученика
//    public void addPupil(Pupil pupil) throws PupilAlreadyExistException {
//        if (pupils.contains(pupil)) throw new PupilAlreadyExistException();
//        pupils.add(pupil);
//    }

//    public String getTeacherFIO() {
//        return teacherFIO;
//    }
//
//    public void setTeacherFIO(String teacherFIO) {
//        this.teacherFIO = teacherFIO;
//    }
//
//    public Pupil getPupil(int numb) {
//        return pupils.get(numb);
//    }
//
//    public void setPupils(ArrayList<Pupil> pupils) {
//        this.pupils = pupils;
//    }
//
//    public int getSchoolBoysCnt() {
//        return pupils.size();
//    }

    public String getTeacherFIO() {
        return teacherFIO;
    }

    public void setTeacherFIO(String teacherFIO) {
        this.teacherFIO = teacherFIO;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Journal that = (Journal) o;
        return //Objects.equals(pupils, that.pupils) &&
                Objects.equals(lessons, that.lessons) &&
                Objects.equals(teacherFIO, that.teacherFIO);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("SchoolJournal{" + " subject= " + this.getClass().getName() +
                ", teacherFIO= " + teacherFIO); //+ ";\npupils: \n");
//        for (int i = 0; i < pupils.size(); i++) {
//            res.append(pupils.get(i).toString() + "\n");
//        }
        res.append("\nList of registers:\n");
        Pair<Calendar,ArrayList<Register>> pair = null;
        for (int i = 0; i < lessons.size(); i++) {
            pair = lessons.get(i);
            res.append("--Date of Lesson: "+pair.getKey().get(Calendar.DAY_OF_MONTH)+ ":"+
                    pair.getKey().get(Calendar.MONTH) +":"+ pair.getKey().get(Calendar.YEAR) + "\n");
            for (int j = 0; j < pair.getValue().size(); j++) {
                res.append(pair.getValue().get(j).pupil + " - " + pair.getValue().get(j).mark +"\n");
            }
        }
        return res.toString();
    }

    protected int findRegistersByDate(Calendar date) {
        Calendar c = null;
        for (int i = 0; i < lessons.size(); i++) {
            c = lessons.get(i).getKey();
            if (date.get(Calendar.YEAR)==c.get(Calendar.YEAR) && date.get(Calendar.MONTH)== c.get(Calendar.MONTH)
                    && date.get(Calendar.DAY_OF_MONTH)==c.get(Calendar.DAY_OF_MONTH)) {
                return i;
            }
        }
        return -1;
    }

    private class Register implements Serializable {//класс запись, в которой в ученику поставлена оценка
        private static final long serialVersionUID = -5882092467075653443L;
        private static final int DEFAULT_MARK = 1;
        private Pupil pupil;
        private Integer mark;

        Register(){
            this.mark = DEFAULT_MARK;
            this.pupil = new Pupil();
        }

        Register(Pupil pupil, int mark) throws MarkOutOfBoundsException {
            if (mark>5 || mark<1) throw new MarkOutOfBoundsException();
            this.mark = mark;
            this.pupil = pupil;
        }

        public Pupil getPupil() {
            return pupil;
        }

        public void setPupil(Pupil pupil) {
            this.pupil = pupil;
        }

        public Integer getMark() {
            return mark;
        }

        public void setMark(Integer mark) throws MarkOutOfBoundsException {
            if (mark>5 || mark<1) throw new MarkOutOfBoundsException();
            this.mark = mark;
        }
    }
}
