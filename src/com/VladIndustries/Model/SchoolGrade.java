package com.VladIndustries.Model;

import com.VladIndustries.MyExceptions.ReadWriteSchoolGradeException;

import java.io.*;
import java.util.HashSet;

public class SchoolGrade implements Serializable{
    private static final long serialVersionUID = -791301372281087262L;
    private HashSet<Journal> schoolJournalHS;//потом организовать порядок предметов в schooljournal
    private int numbClass;
    private char symbByClass;

    public SchoolGrade() {
        this.schoolJournalHS = new HashSet<>();
        this.numbClass = 0;
        this.symbByClass = 'A';
    }

    public SchoolGrade(int numbClass, char symbByClass) {
        this.schoolJournalHS = new HashSet<>();
        this.numbClass = numbClass;
        this.symbByClass = symbByClass;
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

    public Journal getSchoolJournal(String nameJ){//todo
//        Iterator<SchoolJournal> iterator = schoolJournalHS.iterator();
//        SchoolJournal sj = null;
//        while (iterator.hasNext()){
//            sj =iterator.next();
//            if (sj.get.equals(nameJ)) break;
//        }
//        return sj;
        return null;
    }

    public boolean addSchoolJournal(String teacherFIO,String subject,int countScBoys){
        return schoolJournalHS.add(new PhysicsJournal(teacherFIO,countScBoys));
    }

    public boolean addSchoolJournal(PhysicsJournal sj){
        return schoolJournalHS.add(sj);
    }

    public void setSchoolJournal(String nameOldJ,PhysicsJournal newJ){
        removeSchoolJournal(nameOldJ);
        addSchoolJournal(newJ);
    }

    public void removeSchoolJournal(String nameJ){
        schoolJournalHS.remove(getSchoolJournal(nameJ));
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
}
