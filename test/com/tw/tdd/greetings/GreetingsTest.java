package com.tw.tdd.greetings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingsTest {
    @org.junit.Test
    public void shouldGreetBob() throws Exception {
        //given
        Greetings greetings = new Greetings();
        String expectedResult = "Hello Bob";
        //when
        String actualResult = greetings.greet("Bob");
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldGreetJohn() throws Exception {
        //given
        Greetings greetings = new Greetings();
        String expectedResult = "Hello John";
        //when
        String actualResult = greetings.greet("John");
        //then
        assertEquals(expectedResult, actualResult);
    }
}