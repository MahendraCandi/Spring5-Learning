package com.mahendracandi.springhibernate.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement // equal to <tx:annotation-driven transaction-manager="transactionManager"/>
@ComponentScan({"com.mahendracandi.springhibernate.configuration"}) // equal to <context:component-scan  base-package="com.websystique.spring" />
@PropertySource(value = {"classpath:application.properties"}) // equal to <context:property-placeholder location="classpath:application.properties" />
public class HibernateConfiguration {
    @Autowired
    private Environment environment;

//    This method bellow equal to
//    <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean" >
//        <property name="dataSource" ref="dataSource"/>
//        <property name="packagesToScan">
//            <list>
//                <value>com.websystique.spring.model</value>
//            </list>
//        </property>
//        <property name="hibernateProperties">
//            <props>
//                <prop key="hibernate.dialect">${hibernate.dialect}</prop>
//                <prop key="hibernate.show_sql">${hibernate.show_sql:false}</prop>
//                <prop key="hibernate.format_sql">${hibernate.format_sql:false}</prop>
//            </props>
//        </property>
//    </bean>

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {"com.mahendracandi.springhibernate.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return  sessionFactory;
    }

    //this method bellow equal to
//    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
//        <property name="driverClassName" value="${jdbc.driverClassName}" />
//        <property name="url" value="${jdbc.url}"/>
//        <property name="username" value="${jdbc.username}" />
//        <property name="password" value="${jdbc.password}"/>
//
//    </bean>
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    // equal to
    //<property name="hibernateProperties">
    //            <props>
//                <prop key="hibernate.dialect">${hibernate.dialect}</prop>
//                <prop key="hibernate.show_sql">${hibernate.show_sql:false}</prop>
//                <prop key="hibernate.format_sql">${hibernate.format_sql:false}</prop>
//            </props>
//        </property>
    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

//  this method below equal to
//    <bean id="transactionManager"  class="org.springframework.orm.hibernate4.HibernateTransactionManager">
//        <property name="sessionFactory" ref="sessionFactory" />
//    </bean>

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s){
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}
