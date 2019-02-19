package com.test.string.accumulator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAccumulator implements Accumulator<String> {

    public int add(String numbers) throws AccumulatorException{
        if(null == numbers) throw new AccumulatorException("Input cannot be null");
        if(numbers.isEmpty()) return 0;
        return Arrays.stream(split(numbers)).sum();
    }

    private int[] split(String numbers) throws AccumulatorException {
        return Arrays.stream(retrieveDelimitersAndNumbers(numbers)).mapToInt(Integer::parseInt).toArray();
    }

    private String[] retrieveDelimitersAndNumbers(String numbers) throws AccumulatorException {
        String delimeters = ",\n";
        if(numbers.startsWith("//")){
            delimeters = StringUtils.substringBetween(numbers,"//","\n");
            numbers = StringUtils.substringAfter(numbers,"\n");
            String[] delimiterArray = StringUtils.split(delimeters,'|');
            delimeters = StringUtils.join(delimiterArray,"");
        }
        return parseArray(Arrays.asList(StringUtils.split(numbers,delimeters)));
    }

    private String[] parseArray(List<String> numbers) throws AccumulatorException {
        List<Integer> negativeNumbers = new ArrayList<>();
        List<String> finalNumbers = new ArrayList<>();
        for(String number: numbers){
            int iNumber = Integer.parseInt(number);
            if(iNumber < 0) {
                negativeNumbers.add(iNumber);
                continue;
            }
            if(iNumber > 1000) continue;
            finalNumbers.add(String.valueOf(iNumber));
        }
        if(!negativeNumbers.isEmpty()) throw new AccumulatorException("negatives not allowed, "+negativeNumbers);
        return finalNumbers.toArray(new String[0]);
    }

}
