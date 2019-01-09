package com.mahendracandi.springjmsactivemqconsumerex2.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.mahendracandi.springjmsactivemqconsumerex2")
@Import({MessagingConfiguration.class, MessagingListenerConfiguration.class})
public class AppConfig {
}
