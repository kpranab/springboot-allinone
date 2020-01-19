package com.spring.allinone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pranab
 *
 */
@RestController
public class AllInOneController {
	
	@GetMapping("/{name}")
	public String sayHello(@PathVariable("name") String name) {
		return "Hello : "+name;
	}

}
