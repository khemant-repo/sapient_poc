package com.preprations.exception;

// Checked Exception
class InvalidInputException extends Exception {
    public InvalidInputException(String msg) {
        super(msg);
    }
}

// Unchecked Exception
class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String msg) {
        super(msg);
    }
}

public class ExceptionDemo {
    public static void validate(int age) throws InvalidInputException {
        if (age < 0) throw new InvalidInputException("Age cannot be negative");
    }

    public static void triggerUnchecked() {
        throw new CustomRuntimeException("Unchecked error");
    }

    public static void main(String[] args) {
        try {
            validate(-1);
        } catch (InvalidInputException e) {
            System.out.println("Caught checked: " + e.getMessage());
        }

        triggerUnchecked(); // Will throw at runtime
    }
}
