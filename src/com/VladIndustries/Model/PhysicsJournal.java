package com.VladIndustries.Model;

public class PhysicsJournal extends Journal{
    private static final long serialVersionUID = -2591251157040029438L;

    public PhysicsJournal(PhysicsJournal sj){
        super(sj);
    }

    public PhysicsJournal(String teacherFIO,int countScBoys,int cntLessons){
        super(teacherFIO,countScBoys,cntLessons);
    }
}
