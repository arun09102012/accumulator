package com.test.string.accumulator;

public interface Accumulator<T> {
    int add(T numbers) throws AccumulatorException;
}
