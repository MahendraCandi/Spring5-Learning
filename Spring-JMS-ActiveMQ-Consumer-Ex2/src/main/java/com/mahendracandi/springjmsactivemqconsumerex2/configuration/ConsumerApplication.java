package com.mahendracandi.springjmsactivemqconsumerex2.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ConsumerApplication {
    private final static Logger LOG = Logger.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        try {
            Thread.sleep(60000);
        }catch (InterruptedException e){
            LOG.error("ERROR DISINI : ", e);
        }
        ((AbstractApplicationContext) context).close();
    }
}
