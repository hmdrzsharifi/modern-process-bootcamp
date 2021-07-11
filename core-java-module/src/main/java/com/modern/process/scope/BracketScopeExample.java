package com.modern.process.scope;

public class BracketScopeExample {

    public void mathOperationExample(){
        Integer sum = 0;
        {
            Integer number = 2;
            sum = sum + number;
        }

        // compiler error, number cannot be resolved to a variable
        //number++;
    }
}
