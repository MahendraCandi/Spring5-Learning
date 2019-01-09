package com.mahendracandi.springjmsactivemqproducerex2.configuration;

import com.mahendracandi.springjmsactivemqproducerex2.model.Product;
import com.mahendracandi.springjmsactivemqproducerex2.service.ProductService;
import com.mahendracandi.springjmsactivemqproducerex2.util.BasicUtil;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerApplication {
    private static final Logger LOG = Logger.getLogger(ProducerApplication.class);
    private static final AtomicInteger id = new AtomicInteger();

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        beanNames(context);
        ProductService productService = (ProductService) context.getBean("productService");
        productService.getEnvirontment();
        Product product = getProduct();
        LOG.info("APLIKASI : KIRIM ORDER " + product);
        productService.sendProduct(product);
        try {
            Thread.sleep(60000);
        }catch (InterruptedException e){
            LOG.error("ERRO DISINI : ", e);
        }
        ((AbstractApplicationContext) context).close();
    }

    private static Product getProduct(){
        Product p = new Product();
        p.setName("Product : " + id.incrementAndGet());
        p.setProductId(BasicUtil.getUniqueId());
        p.setQty(2);
        return p;
    }

    private static void beanNames(AbstractApplicationContext context){
        String[] beansName = context.getBeanDefinitionNames();
        int i = 1;
        for (String bean : beansName) {
            LOG.info("BEAN " + i + " : " + bean);
            i++;
        }
    }
}
