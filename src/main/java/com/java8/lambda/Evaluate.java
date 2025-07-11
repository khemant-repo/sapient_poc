package com.java8.lambda;

/**
 * custom predicate interface
 * @param <T>
 */
public interface Evaluate<T> {

    boolean isNegative(T t);
}
