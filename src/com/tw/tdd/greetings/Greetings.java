package com.tw.tdd.greetings;

import static java.lang.Character.isLowerCase;

public class Greetings {

    private final String GENERIC_GREETING = "Hello, ";

    public String greet(String name) {


        if(name==null)
            return GENERIC_GREETING+"My friend";

        else if(name.contains(","))
            return GENERIC_GREETING
                    + name.substring(0, name.indexOf(","))
                    + " and"
                    + name.substring(name.indexOf(",")+1, name.length());

        else if(isAllCaps(name))
            return "HELLO " + name + "!!";

        else
            return "Hello " + name;
    }

    private boolean isAllCaps(String name) {
        Boolean returnValue = true;
        for(char currentChar: name.toCharArray())
            returnValue = !isLowerCase(currentChar);
        return returnValue;
    }

}
