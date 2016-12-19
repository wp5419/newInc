package com.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inc.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/print")
	@ResponseBody
	public void print(){
		System.out.println("Test...");
	}
}
