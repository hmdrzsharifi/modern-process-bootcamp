package com.modern.process.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    // field based DI
    //@Autowired
    private Engine engine;

    // field based DI
    //@Autowired
    private Trailer trailer;

    // constructor based DI
   /* public Car(Engine engine, Trailer trailer) {
        this.engine = engine;
        this.trailer = trailer;
    }*/

    // setter based DI
    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // setter based DI
    @Autowired
    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    @Override
    public String toString(){
        return String.format("Engine: %s Trailer: %s", engine, trailer);
    }
}
