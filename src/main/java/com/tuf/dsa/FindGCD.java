package com.tuf.dsa;

public class FindGCD {
    public static void main(String[] args) {
        int n1 = 9, n2=12;
       //int hcf =  gcd(n1,n2);
        int hcf =  gcdBrute(n1,n2);
        System.out.println("HCF of ("+n1+","+n2+") is "+ hcf);
    }

    private static int gcdBetter(int n1, int n2) {

        int gcd = 1;
        for(int i = Math.min(n1,n2); i>0;i--){
            if(n1%i==0 && n2 % i==0){
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    private static int gcdBrute(int n1, int n2) {

        int gcd = 1;
        for(int i = 1; i<=Math.min(n1,n2);i++){
            if(n1%i==0 && n2 % i==0){
                gcd = i;
            }
        }
        return gcd;
    }

    /**
     * Eculodian algo says: gcd(a-b,b) where a> b
     *
     * @param n1
     * @param n2
     * @return
     */
    private static int gcdBestWithEculodianAlgo(int n1, int n2) {
        while (n1>0 || n2==0){
            if(n1>n2){
                n1 = n1%n2;
            }else {
                n2 = n2%n1;
            }
        }
        if(n1==0) return n2;
        else return n1;
    }
}
