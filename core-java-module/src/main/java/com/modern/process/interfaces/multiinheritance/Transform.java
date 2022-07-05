package com.modern.process.interfaces.multiinheritance;

public interface Transform {

    void transform();

    default void printSpecs(){
        System.out.println("Transform Specificatrion");
    }
}
