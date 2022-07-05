package com.modern.process.interfaces.multiinheritance;

public class Car implements Fly, Transform{

    @Override
    public void fly() {
        System.out.printf("Fly");
    }

    @Override
    public void transform() {
        System.out.printf("Transform");
    }
}
