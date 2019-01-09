package com.mahendracandi.springcachingannotationexample.configuration;

import com.mahendracandi.springcachingannotationexample.model.Product;
import com.mahendracandi.springcachingannotationexample.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class CacheApplication {
    private final static Logger log = Logger.getLogger(CacheApplication.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = (ProductService) context.getBean("productService");

        log.info("NASI PADANG ->" + productService.getByName("NASI PADANG"));
        log.info("NASI PADANG ->" + productService.getByName("NASI PADANG"));
        log.info("NASI PADANG ->" + productService.getByName("NASI PADANG"));

        log.info("MIE GORENG ->" + productService.getByName("MIE GORENG"));
        log.info("MIE GORENG ->" + productService.getByName("MIE GORENG"));
        log.info("MIE GORENG ->" + productService.getByName("MIE GORENG"));

        log.info("BUBUR AYAM ->" + productService.getByName("BUBUR AYAM"));
        log.info("BUBUR AYAM ->" + productService.getByName("BUBUR AYAM"));
        log.info("BUBUR AYAM ->" + productService.getByName("BUBUR AYAM"));

        Product p = new Product("NASI PADANG", 20000);
        productService.updateProduct(p);

        log.info("NASI PADANG ->" + productService.getByName("NASI PADANG"));
        log.info("NASI PADANG ->" + productService.getByName("NASI PADANG"));
        log.info("NASI PADANG ->" + productService.getByName("NASI PADANG"));

        log.info("######### REFRESHING ALL PRODUCTS #########");
        productService.refreshAllProducts();

        log.info("NASI PADANG [SETELAH REFRESH]->" + productService.getByName("NASI PADANG"));
        log.info("NASI PADANG [SETELAH REFRESH]->" + productService.getByName("NASI PADANG"));
        log.info("NASI PADANG [SETELAH REFRESH]->" + productService.getByName("NASI PADANG"));

        context.close();

    }
}
