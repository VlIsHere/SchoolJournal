package com.VladIndustries.Model;

import java.io.Serializable;

public class PhysicsJournal extends Journal implements Serializable{
    private static final long serialVersionUID = -2591251157040029438L;

    @Override
    public String getNameSubject() {
        return "ФИЗИКА";
    }

    public PhysicsJournal(PhysicsJournal sj){
        super(sj);
    }

    public PhysicsJournal(String teacherFIO,int cntLessons){
        super(teacherFIO,cntLessons);
    }
}
