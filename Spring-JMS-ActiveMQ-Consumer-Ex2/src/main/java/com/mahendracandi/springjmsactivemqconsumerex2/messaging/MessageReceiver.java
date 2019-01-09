package com.mahendracandi.springjmsactivemqconsumerex2.messaging;

import com.mahendracandi.springjmsactivemqconsumerex2.model.Product;
import com.mahendracandi.springjmsactivemqconsumerex2.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class MessageReceiver {
    private final static Logger LOG = Logger.getLogger(MessageReceiver.class);
    private final static String ORDER_QUEUE = "order_queue";

    @Autowired
    OrderService orderService;

    @JmsListener(destination = ORDER_QUEUE)
    public void receiveMessage(final Message<Product> message) throws JMSException {
        LOG.info("------------------------------------------------------");
        MessageHeaders headers = message.getHeaders();
        LOG.info("APLIKASI MENERIMA HEADERS : " + headers);
        Product product = message.getPayload();
        LOG.info("APLIKASI : PRODUCT : " + product);
        orderService.processOrder(product);
        LOG.info("------------------------------------------------------");
    }
}
