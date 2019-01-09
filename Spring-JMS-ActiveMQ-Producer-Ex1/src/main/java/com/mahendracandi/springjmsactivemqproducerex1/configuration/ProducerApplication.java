package com.mahendracandi.springjmsactivemqproducerex1.configuration;

import com.mahendracandi.springjmsactivemqproducerex1.model.Product;
import com.mahendracandi.springjmsactivemqproducerex1.service.ProductService;
import com.mahendracandi.springjmsactivemqproducerex1.util.BasicUtil;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerApplication {
    private static final Logger log = Logger.getLogger(ProducerApplication.class);
    private static AtomicInteger id = new AtomicInteger();

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = (ProductService) context.getBean("productService");
        Product product = getProduct();
        log.info("Application : KIRIM ORDER " + product );
        productService.sendProduct(product);

        try {
            Thread.sleep(60000);
        }catch (InterruptedException e){
            log.error("Ooppss Error : " , e);
        }

        ((AbstractApplicationContext)context).close();
    }

    public static Product getProduct(){
        Product p = new Product();
        p.setName("Product Kucing meong " + id.incrementAndGet());
        p.setProductId(BasicUtil.getUniqueId());
        p.setQty(5);
        return p;
    }

}
