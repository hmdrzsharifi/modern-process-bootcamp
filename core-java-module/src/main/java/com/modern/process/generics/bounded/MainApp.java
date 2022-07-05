package com.modern.process.generics.bounded;

public class MainApp {

    public static void main(String[] args) {

        // Creting object of sub class B and
        // passing it to Bound as a type parameter
        Bound<B> beb = new Bound<B>(new B());
        beb.doRunTest();

        /*Bound<String> bes = new Bound<String>(new String());
        bes.doRunTest();*/
    }
}
