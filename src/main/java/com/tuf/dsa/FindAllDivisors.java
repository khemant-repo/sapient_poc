package com.tuf.dsa;

public class FindAllDivisors {
    public static void main(String[] args) {

        int n = 36;
        findDivisors(n);
    }

    private static void findDivisors(int n) {

        for(int i=1 ; i<=n; i++){
           if(n%i==0){
               System.out.print(i+" ,");
           }
        }
    }
}
