package com.springaop.example1.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class.getName());

    public void before(){
        LOGGER.info("Entering Method");
    }

    public void after(){
        LOGGER.info("Existing Method");
    }
}
