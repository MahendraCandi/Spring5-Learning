package com.mahendracandi.springscheduledannotations.config;

import com.mahendracandi.springscheduledannotations.scheduling.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling // sama seperti task pada config di xml
public class AppConfig {

    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
}
