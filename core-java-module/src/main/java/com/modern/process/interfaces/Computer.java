package com.modern.process.interfaces;

public class Computer implements Electronic {

    @Override
    public int getElectricityUse() {
        return 10000;
    }

}
