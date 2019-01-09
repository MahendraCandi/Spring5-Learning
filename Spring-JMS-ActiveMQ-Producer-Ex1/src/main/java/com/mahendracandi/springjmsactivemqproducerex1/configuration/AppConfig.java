package com.mahendracandi.springjmsactivemqproducerex1.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.mahendracandi.springjmsactivemqproducerex1")
@Import({MessagingConfiguration.class})
public class AppConfig {
}
