package com.mahendracandi.springprofile.configuration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.mahendracandi.springprofile")
public class AppConfig {
    @Autowired
    public DataSource dataSource;
}
