package com.VladIndustries.Model;

import com.VladIndustries.MyExceptions.DateAlreadyExistException;
import com.VladIndustries.MyExceptions.MarkOutOfBoundsException;
import com.VladIndustries.MyExceptions.PupilAlreadyExistException;

import java.util.Calendar;

public class MathJournal extends Journal {

    public MathJournal(PhysicsJournal sj) {
        super(sj);
    }

    public MathJournal(String teacherFIO, int cntScBoys, int cntLessons) {
        super(teacherFIO, cntScBoys, cntLessons);
    }

    @Override
    public void addMark(Pupil p, Calendar date, int mark) throws PupilAlreadyExistException, MarkOutOfBoundsException, DateAlreadyExistException {

    }

    @Override
    public void removeMark(Pupil p, Calendar date) throws PupilAlreadyExistException {

    }

    @Override
    public void setMark(Pupil p, Calendar date, int mark) throws MarkOutOfBoundsException, PupilAlreadyExistException {

    }

    @Override
    public void removePupil(Pupil pupil) {

    }

    @Override
    public void setPupil(Pupil newp, Pupil oldp) throws PupilAlreadyExistException {

    }

    @Override
    public void addPupil(Pupil pupil) throws PupilAlreadyExistException {

    }
}
