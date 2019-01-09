package com.mahendracandi.springjmsactivemqproducerex2.messaging;

import com.mahendracandi.springjmsactivemqproducerex2.model.InventoryResponse;
import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class MessageReceiver {
    private final static Logger LOG = Logger.getLogger(MessageReceiver.class);
    private final static String ORDER_RESPONSE_QUEUE = "order_response_queue";

    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(final Message<InventoryResponse> message)throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers = message.getHeaders();
        LOG.info("APLIKASI : HEADER RECEIVED NIHHH : " + headers);
        InventoryResponse inventoryResponse = message.getPayload();
        LOG.info("APLIKASI : RESPONSE RECEIVED NIHHH : " + inventoryResponse);
        LOG.info("+++++++++++++++++++++++++++++++++++++++");
    }
}
