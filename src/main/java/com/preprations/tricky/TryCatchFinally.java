package com.preprations.tricky;

public class TryCatchFinally {
    public static void main(String[] args) {

        System.out.println("value of X:"+test());
        System.out.println("Value of Y:"+testY());
    }

    private static int testY() {
        int x= 0;
        try{
            System.out.println("inside try");
            x = 1;
            return x;
        }finally {
            System.out.println("inside finally");
            x = 2;
            return x;
        }
    }

    private static int test() {

        int x= 0;
        try{
            System.out.println("inside try");
            x = 1;
            return x;
        }finally {
            System.out.println("inside finally");
            x = 2;
        }
    }

}
