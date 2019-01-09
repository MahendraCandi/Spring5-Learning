package com.mahendracandi.springjmsactivemqconsumerex1.messaging;

import com.mahendracandi.springjmsactivemqconsumerex1.model.Product;
import com.mahendracandi.springjmsactivemqconsumerex1.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MessageReceiver implements MessageListener {
    Logger log = Logger.getLogger(MessageReceiver.class);

    @Autowired
    MessageConverter messageConverter;

    @Autowired
    OrderService orderService;

    @Override
    public void onMessage(Message message) {
        try {
            log.info("***************************************************");
            Product product = (Product) messageConverter.fromMessage(message);
            log.info("Application : order received : " + product );
            orderService.processOrder(product);
            log.info("***************************************************");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
