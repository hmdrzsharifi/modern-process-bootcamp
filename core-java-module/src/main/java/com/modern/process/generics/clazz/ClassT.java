package com.modern.process.generics.clazz;

public class ClassT<T> {

    T obj;

    public ClassT(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
