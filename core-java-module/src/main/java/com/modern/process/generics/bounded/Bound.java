package com.modern.process.generics.bounded;

public class Bound<T extends A> {

    private T objRef;

    public Bound(T obj){
        this.objRef = obj;
    }

    public void doRunTest(){
        this.objRef.displayClass();
    }
}
