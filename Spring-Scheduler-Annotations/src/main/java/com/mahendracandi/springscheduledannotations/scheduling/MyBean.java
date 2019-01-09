package com.mahendracandi.springscheduledannotations.scheduling;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyBean {
    Logger log = Logger.getLogger(MyBean.class);

    @Scheduled(fixedDelay = 3000) //sama seperti task:scheduled
    public void printMessage(){
        log.info("Kucing dipanggil");
    }

    public void configurTasks(ScheduledTaskRegistrar taskRegistrar){
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor(){
        return Executors.newScheduledThreadPool(10);
    }
}
