package com.java8.lambda;

import java.util.function.Predicate;

public class LambdaEffectivelyFinal {
    String name = "Hemant";

    public static void main(String[] args) {
        int x = 12;

        Predicate<String> lambda = s -> {
        new LambdaEffectivelyFinal().name = "Kumar"; // we can change instance variable.
            System.out.println("X== "+x);
            return s.isEmpty() && x%2==0;
        };
      //  x=4; can't update value of local variable when it is being used in lambda function.
        // why ? because lambda takes screenshot of lambda function so where this
        // lambda will be used the same values it will expect.
        // What is effectively final? effectively final is final in all
        // but terminology, in the sense that I haven't specified the keyword final.
        //
        //That's what effectively final means.
        //
        //It means that the compiler will not let you change that local variable.
        //
        //Once it's been used by the predicate lambda here in this case, because lam does take a snapshot of
        //
        //the local variable and therefore the lambda is just a piece of code.
    }
}
