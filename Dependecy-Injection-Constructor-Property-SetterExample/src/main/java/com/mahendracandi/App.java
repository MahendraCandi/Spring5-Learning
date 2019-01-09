package com.mahendracandi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
    	Communication app = (Communication) context.getBean("communication");
    	app.communicate();
    	context.close();
    }
}
