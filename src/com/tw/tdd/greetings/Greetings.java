package com.tw.tdd.greetings;

import static java.lang.Character.isLowerCase;

class Greetings {

    String greet(String name) {

        final String SHOUT_GREETING = "HELLO ";
        final String GENERIC_GREETING = "Hello, ";
        final char EXCLAMATION_MARK = '!';
        final char DOT = '.';

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
