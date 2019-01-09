package com.mahendracandi.springjmsactivemqproducerex1.messaging;

import com.mahendracandi.springjmsactivemqproducerex1.model.InventoryResponse;
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

    @Override
    public void onMessage(Message message) {
        try {
            log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
            InventoryResponse response = (InventoryResponse) messageConverter.fromMessage(message);
            log.info("Application : order message resceived : " + response );
            log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        }catch (Exception e){
            log.error("Oopss Error : ", e);
        }
    }
}
