package com.mukul.snippets.validation.funcInterface;

public class ValidationResult {
    private final boolean valid;
    private final String message;

    public static ValidationResult ok() {
        return new ValidationResult(true, null);
    }

    public static ValidationResult fail(String message) {
        return new ValidationResult(false, message);
    }

    private ValidationResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public void throwIfInvalid() {
        if (!isValid()) throw new IllegalArgumentException(getMessage());
    }

    public void throwIfInvalid(String fieldName) {
        if (!isValid()) throw new IllegalArgumentException(fieldName + " : " + getMessage());
    }

    public String getMessage() {
        return message;
    }
}