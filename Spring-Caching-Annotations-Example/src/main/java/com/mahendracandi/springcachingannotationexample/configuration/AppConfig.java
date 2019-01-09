package com.mahendracandi.springcachingannotationexample.configuration;

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

@Configuration
@ComponentScan(basePackages = "com.mahendracandi.springcachingannotationexample")
@PropertySource("classpath:application.properties")
@EnableCaching
public class AppConfig {

    @Bean
    public org.springframework.cache.CacheManager cacheManager() throws URISyntaxException {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager(
                getClass().getResource("/ehcache.xml").toURI(),
                getClass().getClassLoader()
        );
        return new JCacheCacheManager(cacheManager);
    }




}
