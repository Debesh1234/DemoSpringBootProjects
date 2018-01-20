package com.example.demo.controller;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Autowired
	private HystixImpl hystixImpl;
	
	ResponseEntity<String> exchange = null;
	
	@RequestMapping("/getAccounts")
	public String getAccounts() {
		try{
			exchange = hystixImpl.getName();
			return exchange.getBody()+"::status code :"+exchange.getStatusCodeValue();
		}catch(Exception e){
			
		}
		return null;
		
	}
	
	@RequestMapping("/getData")
	public String getData() {
		try{
			String data = hystixImpl.getData();
			return data;
		}catch(Exception e){
			
		}
		return null;
		
	}
	
	
}
