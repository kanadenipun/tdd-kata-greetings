package com.tw.tdd.spike;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSpike {

    public String nullTest(String inputString) {
        if(null == inputString)
            return "NULL";
        return String.valueOf(inputString.matches("."));
    }

    public boolean matchersTest(String patternString, String inputString){
        return inputString.matches(patternString);
    }

    public List<String> groupTest(String patternString, String inputString){
        List<String> returnList = new ArrayList<>();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputString);
        while(matcher.find()){
            returnList.add(matcher.group());
        }
        return returnList;
    }
}
