package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HystixImpl {
	
	@Autowired
	private BackEndService backEndService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private ResponseEntity<String> exchange = null;
	
	@HystrixCommand(fallbackMethod = "defaultFallbackCallGetName")
	public ResponseEntity<String> getName(){
		try{
			System.out.println("*********************Inside Main*******************");
			URI endPoint = URI.create("http://localhost:8083/getName");
			return restTemplate.getForEntity(endPoint, String.class);
		}catch(Exception e){
			throw new RuntimeException();
		}
		
	}
	
	public ResponseEntity<String> defaultFallbackCallGetName(){
		System.out.println("*********************Inside fallback*******************");
		return exchange;
		
	}
	
	@HystrixCommand(fallbackMethod = "defaultFallbackCallGetData")
	public String getData(){
		try{
			System.out.println("*********************Inside Main*******************");
			return backEndService.getData();	
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		
	}
	
	public String defaultFallbackCallGetData(){
		System.out.println("*********************Inside fallback*******************");
		return "fallback";
		
	}
		
		
}
