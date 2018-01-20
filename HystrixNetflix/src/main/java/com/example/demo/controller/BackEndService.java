package com.example.demo.controller;

import org.springframework.stereotype.Component;

@Component
public class BackEndService {

	public String getData() throws InterruptedException{
		
		Thread.sleep(15000);
		return "HelloHystrix";
	}
}
