package com.mahendracandi.springAnnotaionsAutowired;

import com.mahendracandi.springAnnotaionsAutowired.config.AppConfig;
import com.mahendracandi.springAnnotaionsAutowired.domain.Application;
import com.mahendracandi.springAnnotaionsAutowired.domain.Bond;
import com.mahendracandi.springAnnotaionsAutowired.domain.Driver;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    final static Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args ){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Bond bond = (Bond) context.getBean("bond");
        bond.showCar();
//        Driver driver = (Driver) context.getBean("driver");
//        logger.debug("Application details : " + driver);
        //byName AutoWiring
//        Application app = (Application) context.getBean("application");
//        System.out.println("Application Details : " + app);
    }
}
