package com.invilliatest.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldResource {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale){
		System.out.println("Teste");
		return messageSource.getMessage("good.morning.message", null, locale);
	}
}
	