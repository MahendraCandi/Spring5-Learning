package com.mahendracandi.springcachingexample.configuration;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.net.URISyntaxException;

@EnableCaching
@Configuration
@ComponentScan(basePackages = "com.mahendracandi.springcachingexample")
@PropertySource(value = {"classpath:application.properties"})
public class AppConfig {
    private final static Logger LOG = Logger.getLogger(AppConfig.class);

    // look at this for example:
    // https://github.com/ehcache/ehcache3-samples/blob/master/fullstack/src/main/java/org/ehcache/sample/config/CacheConfiguration.java
    @Bean
    public org.springframework.cache.CacheManager cacheManager() throws URISyntaxException{
        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager(
                getClass().getResource("/ehcache.xml").toURI(), getClass().getClassLoader()
        );
        return new JCacheCacheManager(cacheManager);
    }
}
