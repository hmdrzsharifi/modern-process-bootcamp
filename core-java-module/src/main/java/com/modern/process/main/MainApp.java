package com.modern.process.main;

public class MainApp {
    public final static synchronized strictfp void main(final String[] args) {
        if (args.length > 0){
            if (args[0].equals("test")){
                System.out.println("test mode");
            } else if (args[0].equals("production")){
                System.out.println("production mode");
            }
        }
    }
}
