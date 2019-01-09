package com.mahendracandi.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.mahendracandi.app.domain.HelloWordlImpl;
import com.mahendracandi.app.domain.HelloWorld;

@Configuration
public class HelloWordConfig {
	
	@Bean(name="helloWordlBean")
	@Description("Contoh helloworld Bean")
	public HelloWorld hellowordl() {
		return new HelloWordlImpl();
	}
}
