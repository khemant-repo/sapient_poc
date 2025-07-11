package com.preprations.exception;

public class UncheckedTest {
    public static void main(String[] args) {
        UserService service = new UserService();

        // This will throw unchecked exception, no need to declare or catch
        service.register("Hemant", 15);
    }
}
