package com.tw.tdd.greetings;

public class Greetings {

    public String greet(String name) {

        return (name==null)?"Hello, My friend": "Hello " + name;
    }
}
