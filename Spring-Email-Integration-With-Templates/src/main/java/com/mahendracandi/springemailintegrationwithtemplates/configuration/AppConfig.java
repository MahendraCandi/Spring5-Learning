package com.mahendracandi.springemailintegrationwithtemplates.configuration;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("deprecations")
@Configuration
@ComponentScan(basePackages = "com.mahendracandi.springemailintegrationwithtemplates")
public class AppConfig {
    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        //send using gmail
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("dummy.mahendracandi@gmail.com");
        mailSender.setPassword("dummymahendracandi1234");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true"); // print every process

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    // Freemarker configuration
    @Bean
    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration(){
        FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean = new FreeMarkerConfigurationFactoryBean();
        freeMarkerConfigurationFactoryBean.setTemplateLoaderPath("/fmtemplates/");
        return freeMarkerConfigurationFactoryBean;
    }

    // Velocity configuration
    @Bean
    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
        Properties prop = new Properties();
        prop.put("resource.loader", "class");
        prop.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return new VelocityEngine(prop);
    }

}
