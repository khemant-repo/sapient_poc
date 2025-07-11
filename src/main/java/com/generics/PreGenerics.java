package com.generics;

import com.preprations.systemdesign.parkinglot.Person;

import java.util.ArrayList;
import java.util.List;

public class PreGenerics {
    public static void main(String[] args) {

        List myList = new ArrayList<>();

        myList.add("string");
        myList.add(1);
        myList.add(new Person());

        System.out.println(myList.get(0));
    }
}
