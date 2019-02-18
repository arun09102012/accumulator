package com.test.string.accumulator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringAccumulator implements Accumulator<String> {

    public int add(String numbers) throws AccumulatorException{
        if(numbers == null) throw new AccumulatorException("Null input");
        if(numbers.isEmpty()) return 0;
        return Arrays.stream(split(numbers)).sum();
    }

    private int[] split(String numbers){
        return Arrays.stream(retrieveDelimitersAndNumbers(numbers)).mapToInt(Integer::parseInt).toArray();
    }

    private String[] retrieveDelimitersAndNumbers(String numbers){
        String delimeters = ",\n";
        if(numbers.startsWith("//")){
            delimeters = StringUtils.substringBetween(numbers,"//","\n");
            numbers = StringUtils.substringAfter(numbers,"\n");
            String[] delimiterArray = StringUtils.split(delimeters,'|');
            delimeters = StringUtils.join(delimiterArray,"");
        }
        return StringUtils.split(numbers,delimeters);
    }

}
