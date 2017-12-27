package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ConfigProps;

@RestController
public class DemoController {
	
	@Autowired
	ConfigProps configProps;
	
	@RequestMapping("/test")
	public String test(){
		return "********Team Name***********"+configProps.getName()+":password is :"+configProps.getPass();
	}

}
