package com.preprations.enumEx;

enum Status {
    NEW("N"), IN_PROGRESS("P"), COMPLETED("C");

    private String code;

    Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        Status s = Status.IN_PROGRESS;
        System.out.println(s.getCode()); // P
    }
}
