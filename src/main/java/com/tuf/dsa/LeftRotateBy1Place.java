package com.tuf.dsa;

import java.util.Arrays;
import java.util.List;

public class LeftRotateBy1Place {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        int temp = list.get(0);
        for (int i=1;i<list.size();i++){
            list.set(i-1,list.get(i));
        }

        list.set(list.size()-1,temp);
        list.forEach(System.out::print);

    }
}
