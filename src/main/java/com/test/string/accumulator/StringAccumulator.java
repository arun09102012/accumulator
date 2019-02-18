package com.test.string.accumulator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringAccumulator implements Accumulator<String> {

    public int add(String numbers) throws AccumulatorException{
        if(numbers != null && numbers.isEmpty()) return 0;
        return Arrays.stream(split(numbers)).sum();
    }

    private int[] split(String numbers){
        String[] numbersStringArray = StringUtils.split(numbers,",\n");
        return Arrays.stream(numbersStringArray).mapToInt(Integer::parseInt).toArray();
    }
}
