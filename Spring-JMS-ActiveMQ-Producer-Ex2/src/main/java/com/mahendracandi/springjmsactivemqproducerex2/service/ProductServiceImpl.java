package com.mahendracandi.springjmsactivemqproducerex2.service;

import com.mahendracandi.springjmsactivemqproducerex2.messaging.MessageSender;
import com.mahendracandi.springjmsactivemqproducerex2.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final static Logger LOG = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Autowired
    Environment environment;

    @Override
    public void sendProduct(Product product) {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++");
        LOG.info("APLIKASI MENGIRIM PERMINTAAN ORDER : " + product);
        messageSender.sendMessage(product);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void getEnvirontment() {
        LOG.info("PESAN ENVIRONTMENT : " + environment.getProperty("tes.environment"));
    }
}
