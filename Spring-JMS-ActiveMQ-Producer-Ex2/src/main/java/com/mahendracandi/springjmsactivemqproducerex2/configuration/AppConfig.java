package com.mahendracandi.springjmsactivemqproducerex2.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.mahendracandi.springjmsactivemqproducerex2")
@Import({MessagingConfiguration.class, MessagingListenerConfiguration.class})
@PropertySource(value = {"classpath:application.properties"})
public class AppConfig {

}
