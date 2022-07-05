package com.modern.process.generics.method;

public class GenericMethod {

    public static void main(String[] args) {

        // Calling generic method with Integer argument
        genericDisplay(11);

        // Calling generic method with String argument
        genericDisplay("Caribou-Academy");

        // Calling generic method with double argument
        genericDisplay(1.0);

    }

    // A Generic method example
    private static <T> void genericDisplay(T element) {
        System.out.println(element);
    }

   /* private static void genericDisplay(double element) {
        System.out.println(element);
    }

    private static void genericDisplay(String element) {
        System.out.println(element);
    }

    private static void genericDisplay(int element) {
        System.out.println(element);
    }*/
}
