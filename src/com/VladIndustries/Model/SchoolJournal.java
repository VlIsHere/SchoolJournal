package com.VladIndustries.Model;

import java.util.ArrayList;

public class SchoolJournal {
    private ArrayList<Schoolboy> schoolBoys;
    private String subject;

    public SchoolJournal(String subject){
        this.subject = subject;
        this.schoolBoys = new ArrayList<>();
    }

    public int getSchoolBoysCnt() {
        return schoolBoys.size();
    }

    public Schoolboy getSchoolBoy(int numb) {
        return schoolBoys.get(numb);
    }

    public void setSchoolBoys(ArrayList<Schoolboy> schoolBoys) {
        this.schoolBoys = schoolBoys;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
