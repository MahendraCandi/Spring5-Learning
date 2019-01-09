package com.mahendracandi.springjmsactivemqproducerex1.messaging;

import com.mahendracandi.springjmsactivemqproducerex1.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component
public class MessageSender {
    final static Logger log = Logger.getLogger(MessageSender.class);

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final Product product){
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(product);
                log.debug("OBJECT MESSAGE TO STRING : " + objectMessage.toString());
                log.debug("OBJECT MESSAGE : " + objectMessage.getObject());
                log.debug("OBJECT MESSAGE : " + objectMessage.getJMSMessageID());
                return objectMessage;
            }
        });
    }
}
