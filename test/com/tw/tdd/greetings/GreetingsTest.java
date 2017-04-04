package com.tw.tdd.greetings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GreetingsTest {

    private Greetings greetings;

    @Before
    public void setUp() throws Exception {
        greetings = new Greetings();
    }

    @Test
    public void shouldGreetBob() throws Exception {

        //given
        String expectedResult = "Hello Bob";
        //when
        String actualResult = greetings.greet("Bob");
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldGreetJohn() throws Exception {
        //given
        String expectedResult = "Hello John";
        //when\
        String actualResult = greetings.greet("John");
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldGreetWithPredefinedMessageIfNoNameIsPassed() throws Exception {
        //given
        String expecteResult = "Hello, My friend";
        //when
        String actualResult = greetings.greet(null);
        //then
        assertEquals(expecteResult, actualResult);
    }
}