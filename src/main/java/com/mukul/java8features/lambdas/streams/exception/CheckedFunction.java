package com.mukul.java8features.lambdas.streams.exception;


@FunctionalInterface
public interface CheckedFunction<T,R> {
    R apply(T t) throws Exception;
}