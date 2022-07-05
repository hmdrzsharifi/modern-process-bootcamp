package com.modern.process.accessmodifiers;

public class SuperPublic {

    // Available within the same package
    static void defaultMethod(){
        System.out.println("defaultMethod()");
    }

    // Always available from anywhere
    static public void publicMethod(){
        System.out.println("publicMethod()");
    }

   // Available within the same class only
    static private void privateMethod(){
        System.out.println("privateMethod()");
    }

    // Available within the same package and subclasses
    static protected void protectedMethod() {
        System.out.println("protectedMethod()");
    }

    private void anotherPrivateMethod(){
        defaultMethod();
        publicMethod();
        privateMethod();
        protectedMethod();
    }
}

class SuperDefault {

}
