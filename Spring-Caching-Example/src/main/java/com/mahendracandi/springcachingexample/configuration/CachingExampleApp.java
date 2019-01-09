package com.mahendracandi.springcachingexample.configuration;

import com.mahendracandi.springcachingexample.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class CachingExampleApp {
    private  final static Logger LOG = Logger.getLogger(CachingExampleApp.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = (ProductService) context.getBean("productService");
        LOG.info("IPHONE -> " + productService.getByName("APPLE"));
        LOG.info("IPHONE -> " + productService.getByName("APPLE"));
        LOG.info("IPHONE -> " + productService.getByName("APPLE"));
        productService.refreshAllProducts();
        LOG.info("IPHONE -> [AFTER REFRESH] " + productService.getByName("APPLE"));
        LOG.info("IPHONE -> [AFTER REFRESH] " + productService.getByName("APPLE"));
        LOG.info("IPHONE -> [AFTER REFRESH] " + productService.getByName("APPLE"));
        context.close();
    }
}
