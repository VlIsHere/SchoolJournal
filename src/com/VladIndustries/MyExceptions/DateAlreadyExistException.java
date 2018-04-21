package com.VladIndustries.MyExceptions;

public class DateAlreadyExistException extends Exception {
    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return "DateAlreadyExistException: Date already exist in Register!";
    }
}
