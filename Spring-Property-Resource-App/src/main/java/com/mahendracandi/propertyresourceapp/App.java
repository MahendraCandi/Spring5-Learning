package com.mahendracandi.propertyresourceapp;

import com.mahendracandi.propertyresourceapp.configuration.AppConfig;
import com.mahendracandi.propertyresourceapp.service.FileService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FileService fileService = (FileService) context.getBean("fileService");

        fileService.readValues();
        context.close();
    }
}
