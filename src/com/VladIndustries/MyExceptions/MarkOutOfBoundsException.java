package com.VladIndustries.MyExceptions;

public class MarkOutOfBoundsException extends Exception {
    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return "MarkOutOfBoundsException: Mark must be between 1 and 5!";
    }
}
