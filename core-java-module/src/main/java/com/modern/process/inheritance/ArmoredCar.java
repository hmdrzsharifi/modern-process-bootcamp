package com.modern.process.inheritance;

public class ArmoredCar extends Car implements Floatable, Flyable {

    private int bulletProofWindows;
    private String model;

    public void remoteStartCar(){
        // this vehicle can be started by using a remote control
    }

    public String getValue(){
        //return super.model; // return value of model defined in base class car
        return this.model; // will return value of model defined in ArmoredCar
        //return model; // will return value of model defined in ArmoredCar
    }

    public static String msg(){
        //return super.msg(); // this won't compile
        return "ArmoredCar";
    }

    @Override
    public void floatOnWater() {
        System.out.printf("floatOnWater");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }

    public void aMethod(){
        //System.out.println(duration); // Won't compile
        System.out.println(Flyable.duration); // output 10
        System.out.println(Floatable.duration); // output 20
    }
}
