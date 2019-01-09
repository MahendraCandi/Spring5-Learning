package com.mahendra.log4jtes;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    final static Logger logger = Logger.getLogger(App.class);
//    final static LoggerPropertyConfigurator logConfig = new LoggerPropertyConfigurator();

    public static void main( String[] args )
    {
//        logConfig.loggerPropertyConfigurator();
        System.out.println("OKE");
        logger.debug("TESS");
    }
}
