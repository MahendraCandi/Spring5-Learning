package com.mahendracandi.app.scheduling;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
    Logger log = Logger.getLogger(MyBean.class);

    /**
     * Catatan: method ini akan running via scheduler, harus mempunyai kembalian berupa void dan tidak boleh mempunyai parameter <br/>
     * Namun bisa dimasukan value dengan cara inject dari bean
     */
    public void printMessage(){
        log.info("Aku dipanggil oleh Spring Scheduler");
    }

    public void printMessage2(){
        log.info("Aku dipanggil oleh Spring Scheduler 2");
    }

    public void printMessage3(){
        log.info("Aku dipanggil oleh Spring Scheduler 3");
    }
}
