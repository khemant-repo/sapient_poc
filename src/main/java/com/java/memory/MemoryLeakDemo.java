package com.java.memory;

public class MemoryLeakDemo {
    static Object1 object1 = new Object1();

    public static void start(){
     try{
         object1.grow();
     }catch (Throwable t){
         t.printStackTrace();
         System.out.println(t);
     }
        System.out.println("App still running...");

        try{
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
