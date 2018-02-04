package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commanlineRunner(ApplicationContext appctx){
		
		String[] beans = appctx.getBeanDefinitionNames();
		
		for(String beanName : beans){
			System.out.println(beanName);
		}
		return null;
	}
	
	
}
