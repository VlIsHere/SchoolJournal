package com.VladIndustries.MyExceptions;

public class PupilDoesntExistInGradeException extends BaseException {
    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return getLogMessage();
    }

    @Override
    public String getLogMessage() {
        return "com.VladIndustries.MyExceptions.PupilDoesntExistInGradeException: Pupil doesnt exist in list of pupils in SchoolGrade!";
    }
}
