package com.mahendracandi.springjmsactivemqproducerex1.configuration;

import com.mahendracandi.springjmsactivemqproducerex1.messaging.MessageReceiver;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.ConnectionFactory;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class MessagingConfiguration {
    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String ORDER_QUEUE = "order-queue";
    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

    private static final Logger log = Logger.getLogger(MessagingConfiguration.class);

    @Autowired
    MessageReceiver messageReceiver;

    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(new ArrayList(Arrays.asList("com.mahendracandi.springjmsactivemqproducerex1")));
        connectionFactory.setObjectMessageSerializationDefered(true);
        log.info("CONNECTION FACTORY BROKER URL : " + connectionFactory.getBrokerURL());
        log.info("CONNECTION FACTORY TRUSTED PACKAGES : " + connectionFactory.getTrustedPackages());
        log.info("CONNECTION FACTORY OBJECT MESSAGE SERIALIZED : " + connectionFactory.isObjectMessageSerializationDefered());
        log.info("CONNECTION FACTORY STATUS : " + connectionFactory.getStats());
        return connectionFactory;
    }

    // Optional, digunakan untuk membuat cache jika jika performance menjadi big concern
//    @Bean
//    public ConnectionFactory cachingConnectionFactory(){
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setTargetConnectionFactory(connectionFactory());
//        connectionFactory.setSessionCacheSize(10);
//        return connectionFactory;
//    }

    // Message listener container digunakanan untuk meminta messageReceiver.
    @Bean
    public MessageListenerContainer getContainer(){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setDestinationName(ORDER_RESPONSE_QUEUE);
        container.setMessageListener(messageReceiver);
        return container;
    }

    // digunakan untuk mengirim pesan
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(ORDER_QUEUE);
        return template;
    }

    @Bean
    MessageConverter messageConverter(){
        return new SimpleMessageConverter();
    }
}
