package com.prowings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
	
	@GetMapping("/hello")
	public @ResponseBody String hello()
	{
		return "Hello... welcome to Spring-MVC-Rest!!!";
	}

}