package com.modern.process.config.xml;

public class SampleAdder {

    public int add(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Make sure all the atguments are greater than zero.");
        }
        return a + b;
    }
}
