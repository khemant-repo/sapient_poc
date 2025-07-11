package com.tuf.dsa;

public class FindFirstOccrenceogGiveNumber {
    public static void main(String[] args) {
        int[] array = {1,0,2,3,2,0,0,4,5,1};
        int n = 3;
        for(int i=0 ; i< array.length; i++){
            if(array[i] == n){
                System.out.println(n +" found at index :"+i);
                break;
            }
        }

    }
}
