package com.VladIndustries.Model;

import com.VladIndustries.MyExceptions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

public class SchoolGrade implements Serializable{
    private static final long serialVersionUID = -791301372281087262L;
    private HashSet<Journal> schoolJournalHS;
    protected ArrayList<Pupil> pupils;//список учеников
    private int numbClass;
    private char symbByClass;

    public SchoolGrade() {
        this.pupils = new ArrayList<>();
        this.schoolJournalHS = new HashSet<>();
        this.numbClass = 0;
        this.symbByClass = 'A';
    }

    public SchoolGrade(int numbClass, char symbByClass, int cntPupils) {
        this.schoolJournalHS = new HashSet<>();
        this.pupils = new ArrayList<>(cntPupils);
        this.numbClass = numbClass;
        this.symbByClass = symbByClass;
    }

    public Journal findJournal(Journal j){
        if (schoolJournalHS.contains(j)){
            for (Journal jrn: schoolJournalHS){
                if (jrn.equals(j)) return jrn;
            }
        }
        return  null;
    }

    public boolean addRegister(Journal j,Calendar date, Pupil p, int mark) throws PupilDoesntExistInGradeException, JournalDoesntExistInGradeException, MarkOutOfBoundsException {
        if (findPupil(p)!=-1) {
            Journal jrn = findJournal(j);
            if (jrn!=null){
               return jrn.addRegister(date,p,mark);
            } else throw new JournalDoesntExistInGradeException();
        }else throw new PupilDoesntExistInGradeException();
    }

    //удаление ЗАПИСИ оценки по дате
    public boolean removeRegister(Journal j,Calendar date,Pupil p)throws PupilDoesntExistInGradeException, JournalDoesntExistInGradeException{
        if (findPupil(p)!=-1) {
            Journal jrn = findJournal(j);
            if (jrn!=null){
                return jrn.removeRegister(date,p);
            }else throw new JournalDoesntExistInGradeException();
        }else throw new PupilDoesntExistInGradeException();
    }

    //изменение оценки в записи
    public boolean setRegister(Journal j,Calendar date,Pupil p,int mark) throws JournalDoesntExistInGradeException, PupilDoesntExistInGradeException, MarkOutOfBoundsException {
        if (findPupil(p)!=-1) {
            Journal jrn = findJournal(j);
            if (jrn!=null){
               return jrn.setRegister(date,p,mark);
            }else throw new JournalDoesntExistInGradeException();
        }else throw new PupilDoesntExistInGradeException();
    }

    //поиск по списку учеников
    public int findPupil(Pupil p) {
        for (int i = 0; i < pupils.size(); i++) {
            if (pupils.get(i).equals(p)) return i;
        }
        return -1;
    }

    //удаление ученика
    public void removePupil(Pupil pupil) {
        pupils.remove(pupil);
    }

    //изменение ученика
    public void setPupil(Pupil newp, Pupil oldp) throws PupilAlreadyExistException {
        int numb = findPupil(newp);
        if (numb == -1) throw new PupilAlreadyExistException();
        pupils.set(numb, newp);
    }

    //добавление ученика
    public void addPupil(Pupil pupil) throws PupilAlreadyExistException {
        if (pupils.contains(pupil)) throw new PupilAlreadyExistException();
        pupils.add(pupil);
    }

    public Pupil getPupil(int numb) {
        return pupils.get(numb);
    }

    public void setPupils(ArrayList<Pupil> pupils) {
        this.pupils = pupils;
    }

    public int getSchoolBoysCnt() {
        return pupils.size();
    }


    public static void serializeSchoolGrade(File file,SchoolGrade... scGr){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(scGr);
            oos.flush();
        } catch (IOException e) {
            try {
                throw new ReadWriteSchoolGradeException();
            } catch (ReadWriteSchoolGradeException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static SchoolGrade[] deserializeSchoolGrade(File file){
        SchoolGrade scGr[] = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
                scGr = (SchoolGrade[]) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            try {
                throw new ReadWriteSchoolGradeException();
            } catch (ReadWriteSchoolGradeException e1) {
                e1.printStackTrace();
            }
        }
        return scGr;
    }

//    public SchoolGrade readFile(File file){
//        SchoolGrade sclGrade = null;
//        try (Scanner in = new Scanner(file)){
//            int numb = in.nextInt();
//            char symb = (char) in.nextInt();//todo mb this wrong but i try
//            int sizeJournal = in.nextInt();
//            HashSet<SchoolJournal> journals = new HashSet<>(sizeJournal);
//            String subject,teacherFIO;
//            for (int i = 0; i < sizeJournal; i++) {
//                subject = in.nextLine();
//                teacherFIO = in.nextLine();
//                numb = in.nextInt();
//                for (int j = 0; j < numb; j++) {
//
//                }
//                journals.add(new SchoolJournal());
//            }
//            sclGrade = new SchoolGrade();
//        }catch (Exception e){
//            try {
//                throw new ReadWriteSchoolGradeException();
//            } catch (ReadWriteSchoolGradeException e1) {}
//        }
//        return sclGrade;
//    }
//
//    public void writeFile(File file){
//        try (PrintWriter out = new PrintWriter(file)){
//            out.println(getNumbClass() + " "+ getSymbByClass());
//            out.println(schoolJournalHS.size());
//            Pupil p;
//            for (SchoolJournal sj: schoolJournalHS){
//                out.println(sj.getSubject());
//                out.println(sj.getTeacherFIO());
//                out.println(sj.getSchoolBoysCnt());
//                for (int i = 0; i < sj.getSchoolBoysCnt(); i++) {
//                    p = sj.getPupil(i);
//                    out.println(p.getFirstName());
//                    out.println(p.getSurname());
//                    out.println(p.getPatronymic());
//                    out.println(p.getCount());
//                    for (int j = 0; j < p.getCount(); j++) {
//                        out.println(p.getDate(j) + " " + p.getMark(j));
//                    }
//                }
//            }
//        }catch (Exception e){
//            try {
//                throw new ReadWriteSchoolGradeException();
//            } catch (ReadWriteSchoolGradeException e1) {}
//        }
//    }

    public Journal getSchoolJournal(Journal j){
//        Iterator<Journal> iterator = schoolJournalHS.iterator();
//        Journal sj = null;
//        while (iterator.hasNext()){
//            sj =iterator.next();
//            if (sj.getClass()==j.getClass()) break;
//        }
        for (Journal sj : schoolJournalHS){
            if (sj.getClass()==j.getClass()) return sj;
        }
        return null;
    }

    public Journal getSchoolJournal(String name){
        for (Journal sj: schoolJournalHS){
            if (sj.getNameSubject().equals(name)) return sj;
        }
        return null;
    }


    public boolean addSchoolJournal(Journal sj){
        return schoolJournalHS.add(sj);
    }

    public void setSchoolJournal(Journal oldJ,Journal newJ){
        removeSchoolJournal(oldJ);
        addSchoolJournal(newJ);
    }

    public void removeSchoolJournal(Journal j){
        schoolJournalHS.remove(getSchoolJournal(j));
    }

    public int getNumbClass() {
        return numbClass;
    }

    public void setNumbClass(int numbClass) {
        this.numbClass = numbClass;
    }

    public char getSymbOfClass() {
        return symbByClass;
    }

    public void setSymbByClass(char symbByClass) {
        this.symbByClass = Character.toUpperCase(symbByClass);
    }

    @Override
    public String toString() {
        String res =  getClass()+": "+ numbClass+ symbByClass + "\n" + "Pupils:\n";
        for (int i = 0; i < pupils.size(); i++) {
            res+=pupils.get(i).toString() + "\n";
        }
        Iterator<Journal> iter = schoolJournalHS.iterator();
        while (iter.hasNext()){
            res+=iter.next().toString() + "\n";
        }
        return  res;
    }
}
