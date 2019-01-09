package com.mahendracandi.springprofile;

import com.mahendracandi.springprofile.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("Development");
        context.scan("com.mahendracandi.springprofile");
        context.refresh();
        context.close();
    }
}
