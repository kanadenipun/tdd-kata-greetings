package com.tw.tdd.greetings;

import static java.lang.Character.isLowerCase;

public class Greetings {

    private final String GENERIC_GREETING = "Hello, ";
    private final String SHOUT_GREETING = "HELLO ";
    private final char DOT = '.';
    private final char EXCLAMATION_MARK = '!';

    public String greet(String name) {


        if(name==null)
            return GENERIC_GREETING
                    +"My friend"
                    + DOT;

        else if(name.contains(","))
            return GENERIC_GREETING
                    + name.substring(0, name.indexOf(","))
                    + " and"
                    + name.substring(name.indexOf(",")+1, name.length())
                    + DOT;

        else if(isAllCaps(name))
            return SHOUT_GREETING
                    + name
                    + EXCLAMATION_MARK;

        else
            return GENERIC_GREETING
                    + name
                    + DOT;
    }

    private boolean isAllCaps(String name) {
        Boolean returnValue = true;
        for(char currentChar: name.toCharArray())
            returnValue = !isLowerCase(currentChar);
        return returnValue;
    }
}
