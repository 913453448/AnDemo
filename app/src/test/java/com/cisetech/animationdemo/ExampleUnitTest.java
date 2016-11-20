package com.cisetech.animationdemo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Calculator calculator;
    @Before
    public void newInstance(){
        calculator=new Calculator();
    }
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals("result erro!",0,calculator.sum(1d,1d),0);
    }
}