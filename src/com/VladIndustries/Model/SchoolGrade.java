package com.VladIndustries.Model;

import java.util.HashSet;

public class SchoolGrade {
    private HashSet<SchoolJournal> schoolJournalHS;//потом организовать порядок предметов в schooljournal
    private int numbClass;
    private char symbByClass;

    public SchoolGrade(int numbClass, char symbByClass) {
        this.schoolJournalHS = new HashSet<>();
        this.numbClass = numbClass;
        this.symbByClass = symbByClass;
    }

    //todo equals & hashcode for schoolJournalHS

    public int getNumbClass() {
        return numbClass;
    }

    public void setNumbClass(int numbClass) {
        this.numbClass = numbClass;
    }

    public char getSymbByClass() {
        return symbByClass;
    }

    public void setSymbByClass(char symbByClass) {
        this.symbByClass = Character.toUpperCase(symbByClass);
    }
}
