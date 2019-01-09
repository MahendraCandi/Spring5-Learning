package com.mahendracandi.springjmsactivemqconsumerex1.configuration;

import com.mahendracandi.springjmsactivemqconsumerex1.messaging.MessageReceiver;
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
import java.util.Arrays;

@Configuration
public class MessagingConfiguration {
    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String ORDER_QUEUE = "order-queue";
    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

    final static Logger log = Logger.getLogger(MessagingConfiguration.class);

    @Autowired
    MessageReceiver messageReceiver;

    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("com.mahendracandi.springjmsactivemqconsumerex1"));
        log.info("CONNECTION FACTORY BROKER URL : " + connectionFactory.getBrokerURL());
        log.info("CONNECTION FACTORY TRUSTED PACKAGES : " + connectionFactory.getTrustedPackages());
        log.info("CONNECTION FACTORY OBJECT MESSAGE SERIALIZED : " + connectionFactory.isObjectMessageSerializationDefered());
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
        container.setDestinationName(ORDER_QUEUE);
        container.setMessageListener(messageReceiver);
        return container;
    }

    // digunakan untuk mengirim pesan
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(ORDER_RESPONSE_QUEUE);
        return template;
    }

    @Bean
    MessageConverter messageConverter(){
        return new SimpleMessageConverter();
    }
}
