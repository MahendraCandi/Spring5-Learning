package com.mahendracandi.springjmsactivemqproducerex2.configuration;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessagingConfiguration {
    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String ORDER_QUEUE = "order_queue";
    private static final Logger LOG = Logger.getLogger(MessagingConfiguration.class);

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(DEFAULT_BROKER_URL);
        //factory.setTrustedPackages(Arrays.asList("com.mahendracandi.springjmsactivemqproducerex2", "java.lang", "javax.security", "java.util", "org.apache.activemq", "org.fusesource.hawtbuf", "com.thoughtworks.xstream.mapper"));
        //factory.setTrustAllPackages(true);
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
        jmsTemplate.setDefaultDestinationName(ORDER_QUEUE);
        return jmsTemplate;
    }
}
