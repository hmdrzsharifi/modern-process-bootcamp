package com.modern.process.config.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdderAfterAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void afterAdvice() {
        logger.info("I'm done calling the method");
    }
}
