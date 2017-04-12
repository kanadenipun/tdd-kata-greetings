package com.tw.tdd.greetings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Greetings {

    private static final String GENERIC_GREETING = "Hello,";
    private Boolean isShout = false;
    private static final String SHOUT_GREETING = "HELLO";
    final char EXCLAMATION_MARK = '!';
    final char DOT = '.';


    String greet(String name) {

        String returnString;

        if(name==null)
            return GENERIC_GREETING +" My friend" + DOT;

        Pattern smallNamePattern = Pattern.compile("([A-Z][a-z]+)");
        Pattern capitalNamePattern = Pattern.compile("([A-Z][A-Z]+)");
        Matcher smallNameMatcher = smallNamePattern.matcher(name);
        Matcher capitalNameMatcher = capitalNamePattern.matcher(name);

        List<String> nameList = new ArrayList<>();

        if(smallNameMatcher.find()) {
            smallNameMatcher.reset();
            while (smallNameMatcher.find()) {
                nameList.add(smallNameMatcher.group());
            }
        }

        if(capitalNameMatcher.find()) {
            capitalNameMatcher.reset();
            while (capitalNameMatcher.find()) {
                nameList.add(capitalNameMatcher.group());
            }
            isShout = true;
        }

        returnString = createReturnString(nameList);
        return isShout?returnString.toUpperCase() + EXCLAMATION_MARK:returnString + DOT;
    }

    private String createReturnString(List<String> nameList) {
        String returnString = isShout?SHOUT_GREETING:GENERIC_GREETING;
        int i = 1;
        int nameListSize = nameList.size();
        for (String name : nameList) {
                returnString += " " + name;
                if(nameListSize-i>2)
                    returnString+= ",";
                else if(nameListSize-i==1)
                    returnString+=" and";
                i++;
        }
        return returnString;
    }

}
