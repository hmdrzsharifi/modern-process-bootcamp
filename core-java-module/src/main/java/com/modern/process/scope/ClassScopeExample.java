package com.modern.process.scope;

public class ClassScopeExample {

    Integer amount = 0;

    public void exampleMethod(){
        amount++;
    }

    public void anotherExampleMethod(){
        Integer anotherAmount = amount + 4;
    }
}
