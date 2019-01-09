package com.mahendra.log4jtes;

import org.apache.log4j.PropertyConfigurator;

public class LoggerPropertyConfigurator {
    public void loggerPropertyConfigurator() {
        PropertyConfigurator.configure("./log4j.properties");
    }
}
