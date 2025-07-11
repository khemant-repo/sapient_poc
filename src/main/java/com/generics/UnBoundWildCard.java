package com.generics;

import com.tuf.dsa.java8.Employee;

import java.util.ArrayList;
import java.util.List;

//List<?> : means list of any type of objects
public class UnBoundWildCard {

    private static void showList(List<Object> names) {
        for (Object o : names){
            System.out.println(o);
        }
    }

    private static void showListWithWildCard(List<?> names) {
        for (Object o : names){
            System.out.println(o);
        }
        // names.add("not allowed"); // write on unbounded wildcard is not allowed, read-only
    }
    public static void main(String[] args) {

        List<Double> doubles = new ArrayList<Double>();
        List<Double> doubles1 = new ArrayList<>();
        doubles.add(12.3);
        // List<Object> objectList = doubles; // not allowed
        // if above code allowed then . we can also add other types which breaks type safety.
        //ex. objectList.add("hemant");
        // to resolve this , you can use wildcards.
        List<String> names = new ArrayList<>();
        names.add("hemant");
        names.add("muskan");

        // showList(names);// not allowed, will break type safety

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        // now with wildcard we can use any type of data
        showListWithWildCard(names);
        System.out.println("------------integers----------------");
        showListWithWildCard(numbers);

        System.out.println("------------Employee----------------");

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1,"heamnt",15000,"DEV"));
        employees.add(new Employee(2,"muskan",10000,"QA"));
        showListWithWildCard(employees);
    }


}
