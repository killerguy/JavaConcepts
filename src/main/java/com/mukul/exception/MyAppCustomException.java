package com.mukul.exception;

public class MyAppCustomException extends Exception {

    private static final long serialVersionUID = -3468376856047982465L;
    private String message = null;

    public MyAppCustomException() {
        super();
    }

    public MyAppCustomException(String message) {
        super(message);
        this.message = message;
    }

    public MyAppCustomException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }



}
