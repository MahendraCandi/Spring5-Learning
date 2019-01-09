package com.mahendracandi.springschedulerquartz.scheduling;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
    Logger log = Logger.getLogger(MyBean.class);

    public void printMessage(){
        log.info("Kucing meong meong MethodInvokingJobDetailFactoryBean menggunakan bulu SimpleTriggerFactoryBean");
    }
}
