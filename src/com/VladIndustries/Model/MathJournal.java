package com.VladIndustries.Model;

import java.io.Serializable;

public class MathJournal extends Journal implements Serializable {

    @Override
    public String getNameSubject() {
        return "МАТЕМАТИКА";
    }

    public MathJournal(PhysicsJournal sj) {
        super(sj);
    }

    public MathJournal(String teacherFIO, int cntLessons) {
        super(teacherFIO, cntLessons);
    }

}
