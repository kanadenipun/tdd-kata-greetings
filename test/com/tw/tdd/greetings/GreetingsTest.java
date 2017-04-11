package com.tw.tdd.greetings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GreetingsTest {

    private Greetings greetings;
    private String expectedResult;
    private String actualResult;

    @Before
    public void setUp() throws Exception {
        greetings = new Greetings();
    }

    @Test
    public void shouldGreetBob() throws Exception {
        expectedResult = "Hello, Bob.";
        actualResult = greetings.greet("Bob");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldGreetJohn() throws Exception {
        expectedResult = "Hello, John.";
        actualResult = greetings.greet("John");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldGreetWithPredefinedMessageIfNoNameIsPassed() throws Exception {
        expectedResult = "Hello, My friend.";
        actualResult = greetings.greet(null);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldGreetWithAShoutIfInputIsAllCaps() throws Exception {
        expectedResult = "HELLO JERRY!";
        actualResult = greetings.greet("JERRY");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldHandleMultipleNames() throws Exception {
        expectedResult = "Hello, Jill and Jane.";
        actualResult = greetings.greet("Jill, Jane");
        assertEquals(expectedResult, actualResult);
    }
}