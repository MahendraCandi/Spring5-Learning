package com.mahendracandi.springschedulerquartz.scheduling;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("anotherBean")
public class AnotherBean {
    Logger log = Logger.getLogger(AnotherBean.class);

    public void printAnotherMessage(){
        log.info("Anjing guk guk dipanggil Quartz Job Bean menggunkana buntut CronTriggerFactoryBean");
    }
}
