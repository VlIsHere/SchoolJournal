package com.VladIndustries.MyExceptions;

public class WrongNumbOfGradeException extends BaseException {
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
        return "com.VladIndustries.MyExceptions.WrongNumbOfGradeException: Numb of grade must be between 1 and 11!";
    }
}
