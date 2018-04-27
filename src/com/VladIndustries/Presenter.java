package com.VladIndustries;

import com.VladIndustries.Model.*;
import com.VladIndustries.MyExceptions.*;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class Presenter {
    public static Logger logInfo = Logger.getLogger("LogInfoInFile");
    private File fileSerial;
    private SchoolGrade[] scG;

    public Presenter(File fileSerial){
        this.fileSerial = fileSerial;
    }

    public Journal getJournalByName(SchoolGrade scg, String nameJ){
        return scg.getSchoolJournal(nameJ.toUpperCase());
    }

    public SchoolGrade getSchoolGrade(int numb) {
        if (scG!=null && numb>=0 && numb<=scG.length){
            return scG[numb];
        } else return null;}

    public SchoolGrade getSchoolGrade(char c,int num){
        for (int i = 0; i < scG.length; i++) {
            if (c ==scG[i].getSymbOfClass() && num == scG[i].getNumbClass()) return scG[i];
        }
        return null;
    }

    public int getSchlGrades(){return scG.length;}

    public String getSchoolGradesToString(){
        String res = "";
        for (int i = 0; i < scG.length; i++) {
            res+= scG[i].toString()+"\n";
        }
        return res;
    }

    public File getFileSerial() {
        return fileSerial;
    }

    public void initialize(){
        scG = new SchoolGrade[2];
        scG[0] = new SchoolGrade(8,'А',6);
        scG[1] = new SchoolGrade(9,'А',6);

        Journal physic = new PhysicsJournal("Андреева Вера Ивановна", 2);
        Journal math = new MathJournal("Аникеев Иван Степанович",2);

        Journal physic2 = new PhysicsJournal("Антонова Инна Ивановна", 2);
        Journal math2 = new MathJournal("Аникеева Светлана Кузнецова",2);

        try {
            Pupil p1 = new Pupil("Гуляев", "Эрик", "Альвианович");
            Pupil p2 = new Pupil("Владимиров", "Давид", "Феликсович");
            Pupil p3 = new Pupil("Кондратьев", "Филипп", "Альбертович");
            Pupil p4 = new Pupil("Григорьев", "Парамон", "Искарович");
            Pupil p5 = new Pupil("Меркушев", "Май", "Авдеевич");
            Pupil p6 = new Pupil("Максимова", "Анна", "Вадимовна");

            scG[0].addPupil(p1);
            scG[0].addPupil(p2);
            scG[0].addPupil(p3);
            scG[0].addPupil(p4);
            scG[0].addPupil(p5);
            scG[0].addPupil(p6);
//            physic.addPupil(p1);
//            physic.addPupil(p2);
//            physic.addPupil(p3);
//            physic.addPupil(p4);
//            physic.addPupil(p5);
//            physic.addPupil(p6);
//
//            math.addPupil(p1);
//            math.addPupil(p2);
//            math.addPupil(p3);
//            math.addPupil(p4);
//            math.addPupil(p5);
//            math.addPupil(p6);

            //25 числа посетили физику
            Calendar calend = new GregorianCalendar(2018,Calendar.APRIL,25);
            physic.addRegister(calend,p1,4);
            physic.addRegister(calend,p2,3);
            physic.addRegister(calend,p3,3);
            physic.addRegister(calend,p4,5);

            //26 числа посетили физику
            Calendar calend2 = new GregorianCalendar(2018,Calendar.APRIL,26);
            physic.addRegister(calend2,p3,4);
            physic.addRegister(calend2,p4,5);
            physic.addRegister(calend2,p5,3);
            physic.addRegister(calend2,p6,2);

            //25 числа посетили матан
            math.addRegister(calend,p1,4);
            math.addRegister(calend,p2,4);
            math.addRegister(calend,p3,4);
            math.addRegister(calend,p4,5);

            //26 числа посетили матан
            math.addRegister(calend2,p3,5);
            math.addRegister(calend2,p4,5);
            math.addRegister(calend2,p5,5);
            math.addRegister(calend2,p6,4);

            scG[0].addSchoolJournal(physic);
            scG[0].addSchoolJournal(math);

            Pupil p7 = new Pupil("Данилова", "Дарья", "Митрофановна");
            Pupil p8 = new Pupil("Ефремова", "Лиза", "Максимовна");
            Pupil p9 = new Pupil("Жданова", "Эрика", "Михаиловна");
            Pupil p10 = new Pupil("Горбачёва", "Эллада", "Прокловна");
            Pupil p11 = new Pupil("Осипов", "Иван", "Викторович");
            Pupil p12 = new Pupil("Кузьмина", "Дарья", "Владимировна");

            scG[1].addPupil(p7 );
            scG[1].addPupil(p8 );
            scG[1].addPupil(p9 );
            scG[1].addPupil(p10);
            scG[1].addPupil(p11);
            scG[1].addPupil(p12);
//            math2.addPupil(p7 );
//            math2.addPupil(p8 );
//            math2.addPupil(p9 );
//            math2.addPupil(p10);
//            math2.addPupil(p11);
//            math2.addPupil(p12);
//
//            physic2.addPupil(p7 );
//            physic2.addPupil(p8 );
//            physic2.addPupil(p9 );
//            physic2.addPupil(p10);
//            physic2.addPupil(p11);
//            physic2.addPupil(p12);

            //25 числа посетили физику

            physic2.addRegister(calend,p7,4);
            physic2.addRegister(calend,p8,3);
            physic2.addRegister(calend,p9,3);
            physic2.addRegister(calend,p10,5);

            //26 числа посетили физику
            physic2.addRegister(calend2,p9,4);
            physic2.addRegister(calend2,p10,5);
            physic2.addRegister(calend2,p11,3);
            physic2.addRegister(calend2,p12,2);

            //25 числа посетили матан
            math2.addRegister(calend,p7,4);
            math2.addRegister(calend,p8,4);
            math2.addRegister(calend,p9,4);
            math2.addRegister(calend,p10,5);

            //26 числа посетили матан
            math2.addRegister(calend2,p9,5);
            math2.addRegister(calend2,p10,5);
            math2.addRegister(calend2,p11,5);
            math2.addRegister(calend2,p12,4);

            scG[1].addSchoolJournal(physic2);
            scG[1].addSchoolJournal(math2);
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    public int findClass(int num,char c){
        for (int i = 0; i < scG.length; i++) {
            if (scG[i].getNumbClass()==num && scG[i].getSymbOfClass()==c){
                return i;
            }
        }
        return -1;
    }

    public boolean addMarkByDate(int numbGrade,char let,Journal j,Calendar date,Pupil p,int mark) throws GradeDoesntExistException, JournalDoesntExistInGradeException, PupilDoesntExistInGradeException, MarkOutOfBoundsException {
        int tmp = findClass(numbGrade,let);
        if (tmp!=-1){
           return scG[tmp].addRegister(j,date,p,mark);
        }else throw new GradeDoesntExistException();
    }

    public boolean removeMarkByDate(int numbGrade,char let,Journal j,Calendar date,Pupil p) throws GradeDoesntExistException, JournalDoesntExistInGradeException, PupilDoesntExistInGradeException {
        int tmp = findClass(numbGrade,let);
        if (tmp!=-1){
            return scG[tmp].removeRegister(j,date,p);
        }else throw new GradeDoesntExistException();
    }

    public boolean setMarkByDate(int numbGrade,char let,Journal j,Calendar date,Pupil p,int mark) throws GradeDoesntExistException, PupilDoesntExistInGradeException, JournalDoesntExistInGradeException, MarkOutOfBoundsException {
        int tmp = findClass(numbGrade,let);
        if (tmp!=-1){
           return scG[tmp].setRegister(j,date,p,mark);
        }else throw new GradeDoesntExistException();
    }

    public void serialSchlGrade(File file){
        SchoolGrade.serializeSchoolGrade(file,scG);
    }

    public void deserialSchlGrade(File file){
        scG  = SchoolGrade.deserializeSchoolGrade(file);
    }
}
