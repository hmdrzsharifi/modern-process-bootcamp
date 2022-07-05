package com.modern.process.generics.clazz;

public class MainApp {

    public static void main(String[] args) {

      /*  ClassA classA = new ClassA(15);
        System.out.println(classA.getObj());

        ClassB classB = new ClassB("Caribou-Academy");
        System.out.println(classB.getObj());*/

        ClassT<Integer> integerClassT = new ClassT<>(15);
        System.out.println(integerClassT.getObj());

        ClassT<String> stringClassT = new ClassT<>("Caribou-Academy");
        System.out.println(stringClassT.getObj());

    }
}
