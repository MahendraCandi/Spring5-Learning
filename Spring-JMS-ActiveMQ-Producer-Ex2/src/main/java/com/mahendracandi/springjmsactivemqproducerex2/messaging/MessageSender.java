package com.mahendracandi.springjmsactivemqproducerex2.messaging;

import com.mahendracandi.springjmsactivemqproducerex2.model.Product;
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
    private final static Logger LOG = Logger.getLogger(MessageSender.class);

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final Product product){
        LOG.info("JMS TEMPLATE DESTINATION NAME : " + jmsTemplate.getDefaultDestinationName());
        LOG.info("JMS TEMPLATE CONNECTION FACTORY : " + jmsTemplate.getConnectionFactory());
        LOG.info("JMS TEMPLATE PRIORITY : " + jmsTemplate.getPriority());
        LOG.info("JMS TEMPLATE DEFAULT DESTINATION : " + jmsTemplate.getDefaultDestination());
        LOG.info("JMS TEMPLATE RECEIVE : " + jmsTemplate.receive());
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(product);
                LOG.info("INI OBJECT MESSAGE JMS ID : " + objectMessage.getJMSMessageID());
                LOG.info("INI OBJECT MESSAGE GET OBJECT : " + objectMessage.getObject());
                LOG.info("INI OBJECT MESSAGE DESTINATION : " + objectMessage.getJMSDestination());
                LOG.info("INI OBJECT MESSAGE " + objectMessage.getJMSTimestamp());
                LOG.info("INI OBJECT MESSAGE " + objectMessage.getJMSType());

                return objectMessage;
            }
        });
    }
}
