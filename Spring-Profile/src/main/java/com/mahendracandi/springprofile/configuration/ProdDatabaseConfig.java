package com.mahendracandi.springprofile.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Profile("Production")
@Configuration
public class ProdDatabaseConfig implements DatabaseConfig{
    final static Logger log = Logger.getLogger(ProdDatabaseConfig.class);

    @Override
    @Bean
    public DataSource createDataSource() {
        log.debug("Create Production Database");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // create ORACLE specifiq properties for production environtment

        return dataSource;
    }
}
