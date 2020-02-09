package com.spring.allinone.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pranab
 *
 */
@RestController
public class AllInOneController {
	
	@Value("${message.hello}")
	private String hello;

	@GetMapping("/sayHello/{name}")
	public String sayHello(@PathVariable("name") String name) {
		return "Hello : " +name;
	}

	@GetMapping(value="/sayHi",produces = MediaType.TEXT_PLAIN_VALUE)
	public String sayHi(@RequestParam("name") String name) {
		return "Hi :"+name;
	}

	@PostConstruct
	private void postConstruct() {
		System.out.println(hello);
	}

}
