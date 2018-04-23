package com.VladIndustries.MyExceptions;

public class ReadWriteSchoolGradeException extends BaseException {
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
        return "com.VladIndustries.MyExceptions.ReadWriteSchoolGradeException: Error in class com.VladIndustries.Model.SchoolGrade";
    }
}
