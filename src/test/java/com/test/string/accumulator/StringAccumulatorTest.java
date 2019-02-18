package com.test.string.accumulator;


import org.junit.Assert;
import org.junit.Test;

public class StringAccumulatorTest {


    @Test
    public void testEmpty() throws AccumulatorException {
        StringAccumulator stringAccumulator = new StringAccumulator();
        Assert.assertEquals(stringAccumulator.add(""),0
        );
    }

    @Test
    public void testOne() throws AccumulatorException{
        StringAccumulator stringAccumulator = new StringAccumulator();
        Assert.assertEquals(stringAccumulator.add("1"),1
        );
    }

    @Test
    public void testTwo() throws AccumulatorException{
        StringAccumulator stringAccumulator = new StringAccumulator();
        Assert.assertEquals(stringAccumulator.add("1,2,3"),6
        );
    }

    @Test
    public void testThree() throws AccumulatorException{
        StringAccumulator stringAccumulator = new StringAccumulator();
        Assert.assertEquals(stringAccumulator.add("1\n\n\n2,3"),6
        );
    }
}
