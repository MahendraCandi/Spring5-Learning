package com.mahendracandi.springprofile.configuration;

import javax.sql.DataSource;

public interface DatabaseConfig {
    public DataSource createDataSource();
}
