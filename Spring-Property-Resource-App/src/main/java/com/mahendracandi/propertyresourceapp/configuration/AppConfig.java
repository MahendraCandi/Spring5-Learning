package com.mahendracandi.propertyresourceapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.mahendracandi.propertyresourceapp")
@PropertySource(value = {"classpath:application.properties"})
public class AppConfig {

    //catatan: bean PropertySourcesPlaceholderConfigurer ini diperlukan untuk membaca ${""} pada anotasi @value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
