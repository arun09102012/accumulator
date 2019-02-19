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

    @Test
    public void testFour() throws AccumulatorException{
        StringAccumulator stringAccumulator = new StringAccumulator();
        Assert.assertEquals(stringAccumulator.add("//***\n1***2***3"),6
        );
    }

    @Test
    public void testFive() throws AccumulatorException{
        StringAccumulator stringAccumulator = new StringAccumulator();
        Assert.assertEquals(stringAccumulator.add("//*|%\n1*2%3"),6
        );
    }

    @Test
    public void testSix() throws AccumulatorException{
        StringAccumulator stringAccumulator = new StringAccumulator();
        Assert.assertEquals(stringAccumulator.add("//***|%%\n1*2%3"),6
        );
    }

    @Test(expected = AccumulatorException.class)
    public void testSeven() throws AccumulatorException{
        StringAccumulator stringAccumulator = new StringAccumulator();
        stringAccumulator.add("-1,-2,3");
    }

    @Test
    public void testEight() throws AccumulatorException{
        StringAccumulator stringAccumulator = new StringAccumulator();
        Assert.assertEquals(stringAccumulator.add("1,1001,2,3"),6
        );
    }

    @Test
    public void testNine() {
        StringAccumulator stringAccumulator = new StringAccumulator();
        try {
            stringAccumulator.add("-1,-2,3");
        } catch (AccumulatorException e) {
            Assert.assertEquals(e.getMessage(),"negatives not allowed, [-1, -2]");
        }
    }

}
