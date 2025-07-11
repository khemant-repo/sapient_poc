package com.preprations.day2.java8;

@FunctionalInterface
interface Parent {
    void method1();
}

//@FunctionalInterface
interface Child extends Parent {
    void method2(); // ❌ ERROR: Two abstract methods now!
}
