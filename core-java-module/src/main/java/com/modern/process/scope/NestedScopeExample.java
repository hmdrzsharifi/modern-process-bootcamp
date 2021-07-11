package com.modern.process.scope;

public class NestedScopeExample {

    String title = "caribou";

    public void printTitle(){
        System.out.println(title);
        String title = "John";
        System.out.println(title);
    }
}
