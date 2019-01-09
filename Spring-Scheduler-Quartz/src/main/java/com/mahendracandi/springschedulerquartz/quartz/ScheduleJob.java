package com.mahendracandi.springschedulerquartz.quartz;


import com.mahendracandi.springschedulerquartz.scheduling.AnotherBean;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ScheduleJob extends QuartzJobBean {

    private AnotherBean anotherBean;

    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        anotherBean.printAnotherMessage();
    }

    public void setAnotherBean(AnotherBean anotherBean){
        this.anotherBean = anotherBean;
    }
}
