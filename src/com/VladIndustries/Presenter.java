package com.VladIndustries;

import com.VladIndustries.Model.*;
import com.VladIndustries.MyExceptions.PupilAlreadyExistException;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Presenter {
    private File fileSerial;

    public Presenter(File fileSerial){
        this.fileSerial = fileSerial;
    }

    public String getSchoolGrades(SchoolGrade...sclGrades){
        String res = null;


        return res;
    }

    public File getFileSerial() {
        return fileSerial;
    }

    public SchoolGrade[] initialize(){
        SchoolGrade[] scG = new SchoolGrade[2];
        scG[0] = new SchoolGrade(8,'A');
        scG[1] = new SchoolGrade(9,'A');

        Journal physic = new PhysicsJournal("Андреева Вера Ивановна", 4,3);
        Journal math = new MathJournal("Аникеев Иван Степанович",4,3);

        Journal physic2 = new PhysicsJournal("Антонова Инна Ивановна", 4,3);
        Journal math2 = new MathJournal("Аникеева Светлана Кузнецова",4,3);

        try {
            physic.addPupil(new Pupil("Гуляев", "Эрик", "Альвианович",3));
            physic.addPupil(new Pupil("Владимиров", "Давид", "Феликсович",3));
            physic.addPupil(new Pupil("Кондратьев", "Филипп", "Альбертович",3));
            physic.addPupil(new Pupil("Григорьев", "Парамон", "Искарович",3));
            physic.addPupil(new Pupil("Меркушев", "Май", "Авдеевич",3));
            physic.addPupil(new Pupil("Максимова", "Анна", "Вадимовна",3));

            math.addPupil(new Pupil("Гуляев", "Эрик", "Альвианович",3));
            math.addPupil(new Pupil("Владимиров", "Давид", "Феликсович",3));
            math.addPupil(new Pupil("Кондратьев", "Филипп", "Альбертович",3));
            math.addPupil(new Pupil("Григорьев", "Парамон", "Искарович",3));
            math.addPupil(new Pupil("Меркушев", "Май", "Авдеевич",3));
            math.addPupil(new Pupil("Максимова", "Анна", "Вадимовна",3));

            scG[0].addSchoolJournal(physic);
            scG[0].addSchoolJournal(math);

            math2.addPupil(new Pupil("Данилова", "Дарья", "Митрофановна",3));
            math2.addPupil(new Pupil("Ефремова", "Лиза", "Максимовна",3));
            math2.addPupil(new Pupil("Жданова", "Эрика", "Михаиловна",3));
            math2.addPupil(new Pupil("Горбачёва", "Эллада", "Прокловна",3));
            math2.addPupil(new Pupil("Осипов", "Иван", "Викторович",3));
            math2.addPupil(new Pupil("Кузьмина", "Дарья", "Владимировна",3));

            physic2.addPupil(new Pupil("Данилова", "Дарья", "Митрофановна",3));
            physic2.addPupil(new Pupil("Ефремова", "Лиза", "Максимовна",3));
            physic2.addPupil(new Pupil("Жданова", "Эрика", "Михаиловна",3));
            physic2.addPupil(new Pupil("Горбачёва", "Эллада", "Прокловна",3));
            physic2.addPupil(new Pupil("Осипов", "Иван", "Викторович",3));
            physic2.addPupil(new Pupil("Кузьмина", "Дарья", "Владимировна",3));
        } catch (PupilAlreadyExistException e) {
            e.printStackTrace();
        }
        scG[1].addSchoolJournal(physic2);
        scG[1].addSchoolJournal(math2);
        return scG;
    }

    public void serialSchlGrade(File file,SchoolGrade ... grades){
        SchoolGrade.serializeSchoolGrade(file);
    }

    public SchoolGrade[] deserialSchlGrade(File file){
        return SchoolGrade.deserializeSchoolGrade(file);
    }

    private class Checker{
        private final Pattern year = Pattern.compile("^$");
        private final Pattern month = Pattern.compile("^$");
        private final Pattern day = Pattern.compile("^$");
        private final Pattern fio = Pattern.compile("^$");

        private boolean checkYear(String s){
            Matcher m = year.matcher(s);
            return m.matches();
        }
    }
}
