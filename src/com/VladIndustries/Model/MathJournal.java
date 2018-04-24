package com.VladIndustries.Model;

public class MathJournal extends Journal {

    public MathJournal(PhysicsJournal sj) {
        super(sj);
    }

    public MathJournal(String teacherFIO, int cntScBoys, int cntLessons) {
        super(teacherFIO, cntScBoys, cntLessons);
    }

}
