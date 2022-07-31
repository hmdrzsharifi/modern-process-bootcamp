package com.modern.process.config.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdderBeforeAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void beforeAdvice() {
        logger.info("I would be executed just before method starts");
    }
}
