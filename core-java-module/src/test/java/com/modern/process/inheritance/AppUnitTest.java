package com.modern.process.inheritance;

import com.modern.process.inheritance.ArmoredCar;
import com.modern.process.inheritance.Car;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppUnitTest {

    @Test
    public void testStaticMethodUsingBaseClassVariable(){
        Car first = new ArmoredCar();
        assertEquals("Car", first.msg());
    }

    @Test
    public void testStaticMethodUsingDerivedClassVariable(){
        ArmoredCar second = new ArmoredCar();
        assertEquals("ArmoredCar", second.msg());
    }
}
