package com.mahendracandi.springjmsactivemqproducerex1.service;

import com.mahendracandi.springjmsactivemqproducerex1.messaging.MessageSender;
import com.mahendracandi.springjmsactivemqproducerex1.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    private static final Logger log = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Override
    public void sendProduct(Product product) {
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("Application : sending order request "+ product);
        messageSender.sendMessage(product);
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
