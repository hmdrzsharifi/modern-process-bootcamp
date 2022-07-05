package com.modern.process.controlstructures;

public class Loops {

    /**
     * Dummy method. Only prints a generic message.
     */
    private static void methodToRepeat(){
        System.out.println("Dummy method.");
    }

    public static void repetitionTo10Examples(){
        for (int i = 1; i <= 10; i++){
            methodToRepeat();
        }

        int whileCounter = 1;
        while (whileCounter <= 10){
            methodToRepeat();
            whileCounter++;
        }

        int count = 1;
        do {
            methodToRepeat();
            count++;
        } while (count < 10);
    }

    /**
     * Finds the index of {@code name} in a list
     * @param name The name to look for
     * @param names The list of names
     * @return The index where the name was found or -1 otherwise
     */
    public static int findFirstInstanceOfName(String name, String[] names){
        int index = 0;
        for ( ; index < names.length; index++){
            if (names[index].equals(name)){
                break;
            }
        }

        return index == names.length ? -1 : index;
    }

    public static String makeListSkippingName(String name, String[] names){
        String list = "";
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)){
                continue;
            }
            list += names[i];
        }
        return list;
    }
}
