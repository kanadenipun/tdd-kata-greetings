package com.tw.tdd.greetings;

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
}