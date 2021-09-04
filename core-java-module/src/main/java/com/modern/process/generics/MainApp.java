package com.modern.process.generics;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        Integer i = (Integer) list.get(0);
    }
}
