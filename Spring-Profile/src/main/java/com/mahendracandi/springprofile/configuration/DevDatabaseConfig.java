package com.mahendracandi.springprofile.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Profile("Development")
@Configuration
public class DevDatabaseConfig implements DatabaseConfig {
    final static Logger log = Logger.getLogger(DevDatabaseConfig.class);

    @Override
    @Bean
    public DataSource createDataSource() {
        log.debug("Creating Dev database");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // set MySQL specific properties for development environtment

        return dataSource;
    }
}
