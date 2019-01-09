package com.mahendracandi.springjmsactivemqconsumerex2.configuration;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import java.util.Arrays;

@Configuration
public class MessagingConfiguration {
    private final static String DEFAULT_URL_BROKER = "tcp://localhost:61616";
    private final static String ORDER_RESPONSE_QUEUE = "order_response_queue";
    private final static Logger LOG = Logger.getLogger(MessagingConfiguration.class);

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(DEFAULT_URL_BROKER);
        factory.setTrustedPackages(Arrays.asList("com.mahendracandi.springjmsactivemqconsumerex2", "java.util", "java.lang"));
//        factory.setTrustAllPackages();
        LOG.info("CONNECTION FACTORY TRUSTED PACKAGES : " + factory.getTrustedPackages());
        LOG.info("CONNECTION FACTORY PROPERTIES : " + factory.getProperties());
        LOG.info("CONNECTION FACTORY BROKER URL : " + factory.getBrokerURL());
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        LOG.info("MASUK KE JMS TEMPLATE METHOD");
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestinationName(ORDER_RESPONSE_QUEUE);
        return jmsTemplate;
    }
}
