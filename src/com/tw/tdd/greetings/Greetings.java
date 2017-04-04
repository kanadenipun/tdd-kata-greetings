package com.tw.tdd.greetings;

import static java.lang.Character.isLowerCase;

public class Greetings {

    public String greet(String name) {

        if(name==null)
            return "Hello, My friend";
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
